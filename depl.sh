
# requirements: The `serverless` npm from serverless.com
# also AWS config in ~/.aws/
aws lambda list-functions | jq '.Functions[]|{FunctionName,Handler}'
aws iam get-user | jq '.User.Arn'

## initial creation: serverless create --template aws-groovy-gradle

# build and deploy
test -f build/distributions/*.zip || gradle build
#   serverless deploy

## faster updates later

    serverless deploy function --function hello

## tested at

curl -s "https://p89vtcmaej.execute-api.us-west-2.amazonaws.com/dev/?alt=altMessage++here" | jq '{altMess,message}'
curl -s "https://bf9pgyhdcc.execute-api.us-west-2.amazonaws.com/dev/hello?alt=hihihi+YOYO" | jq '{altMess,message}'

