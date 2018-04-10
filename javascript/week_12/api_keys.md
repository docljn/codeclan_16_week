There are bots that scan GitHub for these keys to abuse them. Maybe there's not much damage someone can do with a Spotify key. But if someone had your AWS one...they could spin up a million servers and charge it to your credit card!

The solution is to stick it in another file that you then `.gitignore`.

```js
// api_key.js

const API_KEY = "<paste in the token you were given when you signed up for the API>"

// e.g const API_KEY = "BQAdE9IadrGHpgckmYyIlRGH..."

```

```bash
# .gitignore

public/api_key.js
```

```html
<!-- index.html -->

<script src='api_key.js'></script>
<script src='app.js'></script>
```

##### Use the token in our request - if it needs to be in the header

Before we send our request (ie before `request.send()`) we need to include this token in our request so we can be authorized. The name of the header may vary between APIs here's a common format  -

```js
// app.js

const authorizationHeader = "Bearer" + " " + API_KEY;
request.setRequestHeader("Authorization", authorizationHeader);
// ...
// request.send();

```
