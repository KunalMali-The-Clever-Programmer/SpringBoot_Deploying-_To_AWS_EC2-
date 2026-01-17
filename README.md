# 🚀 Spring Boot Deployment on AWS EC2 (Without Docker)

This README contains **step-by-step commands** to deploy and run a **Spring Boot application on AWS EC2** using **Git clone + Maven build + JAR execution**.

---

## 🔹 Prerequisites

* AWS EC2 instance (Amazon Linux 2)
* Security Group ports open:

  * **22** → SSH
  * **8080** → Spring Boot app
* GitHub repository with Spring Boot project

---

## 🔹 Step 1: Connect to EC2

```bash
ssh -i your-key.pem ec2-user@<EC2-PUBLIC-IP>
```

---

## 🔹 Step 2: Update System

```bash
sudo yum update -y
```

---

## 🔹 Step 3: Install Java (Amazon Corretto 17)

```bash
sudo yum install java-17-amazon-corretto -y
```

Verify:

```bash
java -version
```

---

## 🔹 Step 4: Install Git and Maven

```bash
sudo yum install git maven -y
```

Verify:

```bash
git --version
mvn -version
```

---

## 🔹 Step 5: Clone Spring Boot Repository

```bash
git clone <YOUR-GITHUB-REPO-URL>
cd <PROJECT-FOLDER>
```

---

## 🔹 Step 6: Build JAR File

```bash
mvn clean package -DskipTests
```

After build, verify:

```bash
ls target/
```

Expected JAR:

```
<app-name>.jar
```

---

## 🔹 Step 7: Configure Application (IMPORTANT)

Edit:

```bash
vi src/main/resources/application.properties
```

Add:

```properties
server.port=8080
server.address=0.0.0.0
```

Rebuild:

```bash
mvn clean package -DskipTests
```

---

## 🔹 Step 8: Run Spring Boot Application

```bash
java -jar target/<app-name>.jar
```

Access in browser:

```
http://<EC2-PUBLIC-IP>:8080
```

---

## 🔹 Step 9: Run App in Background (Recommended)

```bash
nohup java -jar target/<app-name>.jar > app.log 2>&1 &
```

Check logs:

```bash
tail -f app.log
```

Check running process:

```bash
ps -ef | grep java
```

---

## 🔹 Step 10: Stop / Restart Application

Stop:

```bash
pkill -f jar
```

Restart:

```bash
nohup java -jar target/<app-name>.jar > app.log 2>&1 &
```

---

## 🔹 Common Issues & Fixes

### ❌ App not accessible

✔ Ensure **8080** is open in EC2 Security Group

### ❌ App stops after logout

✔ Use `nohup` or systemd service

### ❌ Port already in use

```bash
netstat -tulnp | grep 8080
```

---

## ✅ Deployment Checklist

* [x] Java installed
* [x] Maven installed
* [x] JAR built successfully
* [x] Port 8080 open
* [x] App running in background

---

## 🚀 Next Improvements

* Run app as **systemd service**
* Use **Nginx reverse proxy**
* Bind app to **port 80**
* Connect **AWS RDS**
* Setup **CI/CD with GitHub Actions**

---

### 👨‍💻 Author

Kunal Mali
