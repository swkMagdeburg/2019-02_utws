FROM node:alpine

ENV PUPPETEER_SKIP_CHROMIUM_DOWNLOAD="1"

RUN npm install -g reveal-md && \
    npm cache clean --force

VOLUME /slides

WORKDIR /slides
ENTRYPOINT ["reveal-md"]
CMD ["."]

