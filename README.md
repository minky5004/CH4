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

https://ch4-minky5004.s3.ap-northeast-2.amazonaws.com/profiles/1/b85d08be-ed82-4ddb-98bf-b4ec3afa5faa_%EC%9C%A4%EC%BB%B4%EC%9D%80%EB%B0%A4%EC%BB%B4%EC%9C%BC%EB%A1%9C%EC%B9%98%ED%99%98%EB%90%98%EC%97%88%EB%8B%A4.png?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECsaDmFwLW5vcnRoZWFzdC0yIkgwRgIhALZaMHlebYaac9L9e3OIGYL2NANCtJi2h3hwr45CKx7PAiEAl8MEMu3efQdTFqP2yFlnAU26cuYaVnAr9QSRARRaOyAq0wUI9P%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgwwODMzMTQwMTI5MDciDNhnXGeU0M2zz%2FAZSCqnBWFnFGRU6%2BK97E5ZubgjeToXSzusKPo4o%2FODbvUogpMDldU4R4iWqWISBxjjteWgRTaWwHFBSBbKdGdNZ4ONJmG93CACgPQrlGEGRH1jcJQejzHFzNgrA%2FYQhzASZCUlscvjsk88EsewqBwDFMgXEB1ciFXH7vZgz1l6ocTIr6mAOUEBNLFoqkblEh24zSblbJrXV%2FFL3jlvgm5iN8EzsreQyPUj%2FlHSs7gUV7%2Bk5aAAt9M817P%2FZzaFnDCDmMocqqgicUyk0SR2%2Br549zIqkJOOSuV1koNBIvX8iclbci7Qx9lAhQeEqFmhrPgAwqHbP8TwEZCAzMqHPIQAWKIHS6TMFZ0ySZ6mj11MTJMlf1icBGpyk7fJrsiZ35YsGQKLzIlQtfw%2FaX0Sy9uVlexKgI2QXZBy72SPszibyuImXH4bVinTOhIISv%2B%2FACcugjUpokX6xuMYdskoIQnFOFnk59Rbw%2F8CrNUaJP8wIVFonK9j3xUtwSqWWqW55Cv1Jv5P%2B4RL7iiJBlM%2Fz0PA5RITL69gV4lXq%2FnLXsHDm7ZvlxHX4cuYMa1H9cYPk0nerrKG6HytiGOU%2BWaExvN%2FIIcTmLXYQZVR7LVdAS0cmE0jYi6pbIG%2BGQPoUWr9KZQ0pVxh50u5owmf04syUNsxNzPm9C2QZ8MwmeTADzX1998rOd%2FZpRfV7d5%2FI7VNEUeKN2560fTBAl3qGVMDYRqLKCJnoYL6dRsO%2FgqVp0kXMlW3xvy57P3u%2FkB%2Fp8V4zPrf0YDmynDuaLQyEYK7VW%2BWWzOS%2B2KEb7qrDG4VXGTkVJPG0bZOYmx%2Bg9oSQiaQZgcYRnjTp3FU2d%2Fcp2muU%2BftB3EXrdldHtg9M%2BOY9nJZCeVesvPc4GbjMfg9uUOMl8iTHdq5QohWybcc7YIwh8qFzAY6sAFyp0%2BSJxXBdEmJevSFavXrRu8g5TkTLTC00aVeSCqb9nRFSIjW8QcoaPLh4lxwm%2Fupa%2BBJhYbvChgova9zbjpTtPa9A%2FXXGRquhljw%2FrDp97a9fI0Pp54EJXXt0KSTW0KWqtC1bfuOJD05pjrSY4TNbvKhSsLV%2FVmKt7eOITjPOilWpFiRe5szAUXR3JLe9x3qnbx35tO7SinnSxWw52XpWlFgika4PJC6Xd1AAD6rsA%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260203T035741Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIARGZPG6LV4PZDKMFV%2F20260203%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=179d78c6c0ce34cea87bdf973e87facbfea95446be33934fbde45fbe0564b9da

현재 S3로 업로드한 프로필 사진의 Presigned URL 
만료 시간 : 2026년 2월 3일 03시 57분 41초 (UTC 기준)