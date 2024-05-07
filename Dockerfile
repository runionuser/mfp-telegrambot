FROM meddream/jdk17:latest
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=mfptgbot
ENV BOT_TOKEN=6603544152:AAGSx1Qh3LFItBSaLBcBal8Yg_mlW8vZ-_w
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
