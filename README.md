# JAVA_Project - 학생 관리 시스템

이 프로젝트는 Java의 **Swing GUI**와 **MySQL 데이터베이스(JDBC)**를 활용한 **학생 관리 프로그램**입니다. 사용자는 학생 정보를 등록, 조회, 수정, 삭제(CRUD)할 수 있습니다.

## 🧩 주요 기능

- 학생 정보 등록
- 학생 목록 조회
- 학생 정보 수정 및 삭제
- GUI 기반 사용자 인터페이스 (Java Swing)
- MySQL과의 연동 (JDBC)

## 🛠️ 사용 기술

- **Java 17+**
- **Swing (GUI)**
- **MySQL 8.x**
- **JDBC (MySQL Connector)**
- IntelliJ IDEA

## 📁 폴더 구조
JAVA_Project/
│
├── src/               # 자바 소스 코드
│   └── Project/src/   # 실제 실행 클래스(StudentGUI 등)
│
├── lib/               # JDBC 등 외부 라이브러리 (예: mysql-connector)
│
├── out/               # 컴파일된 클래스 파일
│
└── .gitignore         # Git에서 제외할 파일 설정

## ⚙️ 실행 방법

1. 이 저장소를 클론합니다:
```bash
git clone https://github.com/Lee-sung-il/JAVA_Project.git

String url = "jdbc:mysql://localhost:3306/studentdb";
String user = "root";
String password = "yourpassword";
```
