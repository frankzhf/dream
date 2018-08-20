# dream
mvn versions:set -DnewVersion=1.0.${currentValue}+1

mvn clean install -Dmaven.test.skip=true

mvn deploy -Dmaven.test.skip=true