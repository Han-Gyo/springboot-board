# Spring Boot 게시판 프로젝트

## 개요
Spring Boot와 JPA를 사용하여 게시판 CRUD 기능을 구현한 프로젝트입니다.  
기존 Spring MVC + JDBC Template 구조를 Spring Boot 환경에서 다시 정리하는 것을 목표로 했습니다.

## 기술 스택
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- JSP / JSTL
- Gradle

## 주요 기능
- 게시글 목록 조회 (/boards)
- 게시글 상세보기 (/boards/{id})
- 게시글 작성 (/boards/write)
- 게시글 수정 (/boards/update/{id})
- 게시글 삭제 (/boards/delete/{id})

## 구조
Controller → Service → Repository → DB  
Controller → Model → JSP(View)

## 학습 내용
- JPA 기반 CRUD 구현
- 계층 구조 분리 (Controller, Service, Repository)
- Model을 통한 View 데이터 전달

## 향후 계획
- MyBatis 적용
- 페이징 처리
- 로그인 기능 추가
