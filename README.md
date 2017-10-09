# Heroku deployment
<li> heroku plugins:install heroku-cli-deploy </li>
<li>  heroku create --no-remote</li>
<li> heroku deploy:jar out/artifacts/storage_soap/storage_soap.jar --app webstorage-soap </li>
<li> heroku deploy:jar out/artifacts/jetty_webapp/jetty_webapp.jar --app webstorage-jetty</li>
