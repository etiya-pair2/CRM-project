FROM node:20 AS build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install --legacy-peer-deps

COPY . .
RUN npm install -g @angular/cli --legacy-peer-deps \
  && ng build --configuration production

FROM nginx:alpine

COPY --from=build /app/dist/etiya9.angular/browser /usr/share/nginx/html

EXPOSE 80
