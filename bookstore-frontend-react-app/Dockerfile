##### Dockerfile #####
## build stage ##
FROM node:18.18-alpine as build
WORKDIR /app
COPY . .
RUN yarn
RUN yarn build

## run stage ##
FROM nginx:alpine
RUN mkdir /run
COPY --from=build /app/build /run
