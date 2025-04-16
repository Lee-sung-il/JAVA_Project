
# JAVA_Project - 학생 관리 시스템

이 프로젝트는 Java의 **Swing GUI**와 **MySQL 데이터베이스(JDBC)**를 활용한 **학생 관리 프로그램**입니다. 사용자는 학생 정보를 등록, 조회, 수정, 삭제(CRUD)할 수 있습니다.

## 🧩 주요 기능

- 학생 정보 등록
- 학생 목록 조회
- 학생 정보 수정 및 삭제
- GUI 기반 사용자 인터페이스 (Java Swing)
- MySQL과의 연동 (JDBC)

## 🛠️ 사용 기술

- Java 
- Swing (GUI)
- MySQL 8.x
- JDBC (MySQL Connector)
- IntelliJ IDEA


## 실행 화면


![Image](https://github.com/user-attachments/assets/b256776a-09bc-4734-ac46-01f1daac669d)

![Image](https://github.com/user-attachments/assets/a1eaef45-215a-4e22-a5e9-87a9d6ba8c51)

![Image](https://github.com/user-attachments/assets/9470a666-a37c-4f95-af16-330d2d44d5ad)

![Image](https://github.com/user-attachments/assets/3a4e5259-544e-4e9b-abf5-ebd1ed285b20)

## 📁 폴더 구조

```
JAVA_Project/
├── lib/                       # 외부 라이브러리 (JDBC 등)
│   ├── mysql-connector-j-8.3.0.jar
│   └── protobuf-java-3.25.1.jar
│
├── out/                       # 컴파일된 클래스 파일 (IDE 자동 생성)
│   └── production/JAVA_Project/
│       └── Project/src/
│           └── StudentGUI.class
│
├── src/                       # 메인 자바 소스 디렉터리
│   └── Project/
│       └── src/
│           ├── Student.java              # 학생 클래스 (DTO)
│           ├── StudentDAO.java           # DB 연결 및 로직
│           ├── StudentGUI.java           # Swing GUI 메인 클래스
│           └── DBUtil.java               # JDBC 연결 유틸리티
│
├── .gitignore                 # Git 추적 제외 설정
├── JAVA_Project.iml           # IntelliJ 프로젝트 설정 파일
└── README.md                  # 프로젝트 설명 파일 (이 파일)
```

## 📊 시스템 구성도

```
[사용자 입력]
      ↓
[StudentGUI.java] ⇄ [StudentDAO.java] ⇄ [MySQL DB]
      ↓                     ↑
[화면 출력]         [DB 연결: DBUtil.java]
```

## ⚙️ 실행 방법

1. 이 저장소를 클론합니다:

```bash
git clone https://github.com/Lee-sung-il/JAVA_Project.git
```

2. MySQL에 데이터베이스 및 테이블을 생성합니다:

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id  VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    gender CHAR(1)
);
```

3. `StudentDAO.java` 또는 설정 파일에 DB 연결 정보 입력:

```java
String url = "jdbc:mysql://localhost:3306/studentdb";
String user = "root";
String password = "yourpassword";
```

4. IntelliJ에서 `login` 실행

