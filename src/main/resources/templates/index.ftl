<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>index</title>
  <link rel="stylesheet" href="/static/css/bootstrap.min.css">
  <link rel="stylesheet" href="/static/css/ie10-viewport-bug-workaround.css">
  <script src="/static/js/jquery-3.3.1.js"></script>
  <script src="/static/js/bootstrap.bundle.min.js"></script>
  <script src="/static/js/app.js"></script>
  <script src="/static/js/ie10-viewport-bug-workaround.js"></script>
</head>

<body>
  <div class="container">
    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
          </ul>
        </nav>
        <h5>北京</h5>
        <hr />
      </div>


      <div id="cont" class="container">




      </div> <!-- /container -->

      <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
      </footer>

    </div>

</body>

<script>

  String.prototype.format = function (args) {
    var result = this;
    if (arguments.length < 1) {
      return result;
    }

    var data = arguments;		//如果模板参数是数组
    if (arguments.length == 1 && typeof (args) == "object") {
      //如果模板参数是对象
      data = args;
    }
    for (var key in data) {
      var value = data[key];
      if (undefined != value) {
        result = result.replace("{" + key + "}", value);
      }
    }
    return result;
  }

  function getContent() {

    var template = '<div class="row">\
<div class="col-4">\
  <div class="pic">\
    <img style="max-width: 100%; height: auto;" src="{0}"\
      alt="">\
  </div>\
\
</div>\
\
<div class="col-8">\
\
  <p> <span > {1}</span> <span class="status"></span></p>\
  <br>\
  <p><span> {2}<span>  <span>{3} </span></p>\
  <br>\
  <p> <span id="area">{4}</span>{5} &nbsp; <span>{6}</span></p>\
  <br>\
</div>\
</div>';




    $.get("http://192.168.89.138:8080/fang").done(function (res) {
      var houses = res.data;

      if (houses == null) {
        return;
      }
      var houses_length = houses.length;

      var eles_length = $("div#cont>div.row").length;
      for (let i = 1; i <= houses_length; i++) {
       
        console.log(i + "+++++++" + houses_length + "+++++" + eles_length);
        var house = res.data[i - 1]
        var new_ele = template.format(house.img, house.title, house.info, house.phoneNumber, house.district, house.community, house.price);
        if (i > eles_length) {
          $("div#cont").append(new_ele);
        } else {
          
          $(`div#cont>div.row:eq(${i - 1})`).replaceWith(new_ele);
          javascript:call.jsCall(house.phoneNumber);
        }
      }
    }
    )
  }



  setInterval(getContent, 2000)
</script>

</html>