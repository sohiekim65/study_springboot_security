<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Log Out</title>
    <link
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
      crossorigin="anonymous"
    />
    <link
      href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
      rel="stylesheet"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="container">
      <form class="form-signin" method="post" action="/logout">
        <h2 class="form-signin-heading">We Made Are you sure you want to log out?</h2>
        <input
          name="_csrf"
          type="hidden"
          value="3639213e-aed6-45b2-b252-5a03f5ee394f"
        />
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Log Out
        </button>
      </form>
    </div>
  </body>
</html>
