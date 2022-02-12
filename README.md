# spring

# H2DB
https://www.h2database.com/html/download-archive.html
1.위 URL에서 zip파일 다운로드 및 설치
2.권한 주기: chmod 755 h2.sh (맥 사용시 반드시) 실행: ./h2.sh
3.~/test.mv.db 파일 생성 확인(없을시 vi 명령어로 빈 파일 생성)
4.h2디비 실행(2의 실행명령어 터미널에 입력시 브라우저에서 자동실행됨)
5.jdbcurl 입력란 jdbc:h2:~/test (최초 한번,이후부터는 jdbc:h2:tcp://localhost/~/test 입력하여 접속)
6.user name은 sa입력(패스워드 입력 x)

