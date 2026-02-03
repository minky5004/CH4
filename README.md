# CH 4 클라우드_아키텍처 설계 & 배포

## LV.0 AWS Budget 설정
![img.png](img.png)

AWS의 Budget을 월 예산 $100로 설정한 화면.

## LV.1 네트워크 구축 및 핵심 기능 배포

43.201.100.109 현재 설정 완료한 ch4-cloud-ec2의 Public IP 주소

## LV.2 DB 분리 및 보안 연결하기

![img_1.png](img_1.png)

/actuator/info에 접속했을 때, Parameter Store에 저장했던 또는 확인용 파라미터 값이 JSON으로 출력되는 URL
http://43.201.100.109:8080/actuator/info

![img_2.png](img_2.png)
인바운드 규칙의 Source를 IP주소가 아닌 EC2의 보안 그룹 ID로 설정

## LV.3 프로필 사진 기능 추가와 권한 관리


현재 S3로 업로드한 프로필 사진의 Presigned URL 
만료 시간 : 2026년 2월 3일 03시 57분 41초 (UTC 기준)
