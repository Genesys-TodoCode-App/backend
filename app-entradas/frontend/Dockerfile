FROM node:19-alpine as build
WORKDIR /app
COPY package*.json ./
ENV PATH /app/node_modules/.bin:$PATH
RUN npm ci
COPY . .
RUN npm run build

# Segunda etapa: copiar los archivos de compilación en una imagen de Nginx y configurar Nginx
FROM nginx:stable-alpine
COPY --from=build app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 3000
CMD ["nginx", "-g", "daemon off;"]