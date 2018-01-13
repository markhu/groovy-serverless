
# requirements

The `serverless` npm from serverless.com
AWS config in ~/.aws/

## initial creation

    serverless create --template aws-groovy-gradle

## mods

    edited the serverless.yml file to create a GET callable URL

# build and deploy

    gradle build
    serverless deploy

## faster updates later

    serverless deploy function --function hello  # scripted in ./depl.sh

## tested at

https://p89vtcmaej.execute-api.us-west-2.amazonaws.com/dev/?k=vvvv

