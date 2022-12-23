FROM nginx:1.17

COPY build/ /usr/share/nginx/html/

RUN rm -rf /etc/nginx/conf.d/default.conf
COPY ./nginx.conf /etc/nginx/conf.d

EXPOSE 80