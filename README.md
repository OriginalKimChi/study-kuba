## 스터디 쿠바 마지막

### `application.yml & HealthApi.java` 수정

1. 현재 설정은 애플리케이션 내에서 발생되는 로그를 stdout으로 출력이 되고 있다.
   `원한다면 server tomcat의 access log도 stdout으로 출력하도록 설정`
2. HealthApi의 /health endpoint에서 로그를 출력하도록 추가

### 애플리케이션 배포

1. default-pool node의 각자 namespace에 해당 application을 배포 (_nodeSelector_ 사용)
2. `/health` endpoint를 주기적으로 찌르는 [cronjob](https://kubernetes.io/ko/docs/concepts/workloads/controllers/cron-jobs/)
   resource를 application과 동일한 node & namespace에 배포 (_podAffinity_ 사용)
3. 주기적으로 로그가 생성되고 있는지 확인

### Loki(PLG) stack 배포

1. [helm](https://helm.sh/docs/intro/install/) 을 통한 loki stack을 monitoring-pool의 각자 namespace에
   배포 `Deploy Loki Stack (Loki, Promtail, Grafana, Prometheus)` (https://grafana.com/docs/loki/latest/installation/helm/)
2. [Logging] Grafana의 Explore 탭에서 주기적으로 생성되는 로그 확인. (아마 모든 설정이 잘 되어있겠지만) 로그가 보이지 않는다면 datasource 등의 설정 값 확인이
   필요 `Promtail configuration (https://grafana.com/docs/loki/latest/clients/promtail/configuration/)으로 세세한 설정이 필요할 수도..`
3. [Monitoring] [Grafana Dashboard](https://grafana.com/grafana/dashboards) 에서 원하는 Dashboard들을 import해서
   확인 `원한다면 Custom Dashboard 구성: PromQL 사용`

* ~7/3일까지