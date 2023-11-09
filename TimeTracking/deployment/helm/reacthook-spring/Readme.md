Example customValues.yaml

```yaml
ingress:
  enabled: true
  hosts:
    - host: <HOSTNAME>
      paths: 
        - /timetracking
  tls: 
   - secretName: <TLS-SECRET>
     hosts:
       - <HOSTNAME>

mariadb:
  image:
    registry: <CUSTOM-REGISTRY-IF-NEEDED>
    pullSecrets: 
      - <PULL-SECRETS-FOR-THE-CUSTOM-REGISTRY>
  auth:
    rootPassword: root #change
    database: timetracking #change
    username: timetracking #change
    password: timetracking #change

github:
  registry:
    username: <GITHUB-USERNAME>
    pat: <GENERATED-IN-GITHUB> #you only need to be able to read packages 
```
