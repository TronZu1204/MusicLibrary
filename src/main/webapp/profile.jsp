<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <meta name="keywords" content="Mosaic Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- Custom CSS -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <!-- Graph CSS -->
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- jQuery -->
        <!-- lined-icons -->
        <link rel="stylesheet" href="css/icon-font.css" type='text/css' />
        <!-- //lined-icons -->
        <!-- Meters graphs -->
        <script src="js/jquery-2.1.4.js"></script>
    </head>
    <body class="sticky-header left-side-collapsed"  onload="initMap()">
        <section>
            <div class="left-side sticky-left-side">

                <!--logo and iconic logo start-->
                <div class="logo">
                    <h1><a href="index.jsp">Mosai<span>c</span></a></h1>
                </div>
                <div class="logo-icon text-center">
                    <a href="index.jsp">M </a>
                </div>

                <div class="left-side-inner">

                    <!--sidebar nav start-->
                    <ul class="nav nav-pills nav-stacked custom-nav">
                        <li><a href="index.jsp"><i class="lnr lnr-home"></i><span>Home</span></a></li>
                        <li><a href="#"><i class="camera"></i> <span>Radio</span></a></li>
                        <li><a href="#" data-toggle="modal" data-target="#myModal1"><i class="fa fa-th"></i><span>Apps</span></a></li>
                        <li><a href="#"><i class="lnr lnr-users"></i> <span>Artists</span></a></li> 
                        <li><a href="#"><i class="lnr lnr-music-note"></i> <span>Albums</span></a></li>						
                        <li class="menu-list"><a href="#"><i class="lnr lnr-indent-increase"></i> <span>Browser</span></a>  
                            <ul class="sub-menu-list">
                                <li><a href="#">Artists</a> </li>
                                <li><a href="#">Services</a> </li>
                            </ul>
                        </li>
                        <li><a href="#"><i class="lnr lnr-book"></i><span>Blog</span></a></li>
                        <li><a href="#"><i class="lnr lnr-pencil"></i> <span>Typography</span></a></li>
                        <li class="menu-list"><a href="#"><i class="lnr lnr-heart"></i>  <span>My Favourities</span></a> 
                            <ul class="sub-menu-list">
                                <li><a href="#">All Songs</a></li>
                            </ul>
                        </li>
                        <li class="menu-list"><a href="#"><i class="fa fa-thumb-tack"></i><span>Contact</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="#">Location</a> </li>
                            </ul>
                        </li>
                        <li class="active"><a href="profile.jsp"><i class="lnr lnr-user"></i><span>Profile: ${loggeduser.name}</span></a></li>
                    </ul>
                    <!--sidebar nav end-->
                </div>
            </div>

            <!-- main content start-->
            <div class="main-content">
                <!-- header-starts -->
                <div class="header-section">
                    <!--toggle button start-->
                    <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
                    <!--toggle button end-->
                    <!--notification menu start -->
                    <div class="menu-right">
                        <div class="profile_details">		
                            <div class="col-md-4 serch-part">
                                <div id="sb-search" class="sb-search">
                                    <form action="#" method="post">

                                        <input class="sb-search-input" placeholder="Search" type="search" name="search" id="search">
                                        <input class="sb-search-submit" type="submit" value="">
                                        <span class="sb-icon-search"> </span>
                                    </form>
                                </div>
                            </div>
                            <!-- search-scripts -->
                            <script src="js/classie.js"></script>
                            <script src="js/uisearch.js"></script>
                            <script>
        new UISearch(document.getElementById('sb-search'));
                            </script>
                            <!-- //search-scripts -->
                            <!---->
                            <div class="col-md-4 player">
                                <div class="audio-player">
                                    <audio id="audio-player"  controls="controls">
                                        <source src="media/Blue Browne.ogg" type="audio/ogg"></source>
                                        <source src="media/Blue Browne.mp3" type="audio/mpeg"></source>
                                        <source src="media/Georgia.ogg" type="audio/ogg"></source>
                                        <source src="media/Georgia.mp3" type="audio/mpeg"></source></audio>
                                </div>
                                <!---->
                                <script type="text/javascript">
                                    $(function () {
                                        $('#audio-player').mediaelementplayer({
                                            alwaysShowControls: true,
                                            features: ['playpause', 'progress', 'volume'],
                                            audioVolume: 'horizontal',
                                            iPadUseNativeControls: true,
                                            iPhoneUseNativeControls: true,
                                            AndroidUseNativeControls: true
                                        });
                                    });
                                </script>
                                <!--audio-->
                                <link rel="stylesheet" type="text/css" media="all" href="css/audio.css">
                                <script type="text/javascript" src="js/mediaelement-and-player.min.js"></script>
                                <!---->


                                <!--//-->
                                <ul class="next-top">
                                    <li><a class="ar" href="#"> <img src="images/arrow.png" alt=""/></a></li>
                                    <li><a class="ar2" href="#"><img src="images/arrow2.png" alt=""/></i></a></li>

                                </ul>	
                            </div>
                            <div class="col-md-4 login-pop">
                                <c:choose>
                                    <c:when test="${loggeduser == null}">
                                        <div id="loginpop"> <a href="#" id="loginButton"><span>Login <i class="arrow glyphicon glyphicon-chevron-right"></i></span></a><a class="top-sign" href="#" data-toggle="modal" data-target="#myModal5"><i class="fa fa-sign-in"></i></a>
                                            <div id="loginBox">  
                                                <form action="login" method="post" id="loginForm">
                                                    <p>${message}</p>
                                                    <input type="hidden" name="action" value="loginUser">

                                                    <fieldset id="body">
                                                        <fieldset>
                                                            <label for="email">Email Address</label>
                                                            <input type="text" name="loginEmail" id="email">
                                                        </fieldset>
                                                        <fieldset>
                                                            <label for="password">Password</label>
                                                            <input type="password" name="loginPass" id="password">
                                                        </fieldset>
                                                        <input type="submit" id="login" value="Sign in">
                                                        <label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
                                                    </fieldset>
                                                    <span><a href="#">Forgot your password?</a></span>
                                                </form>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div id="loginpop"> <a href="#" id="loginButton"><span>Signed in</span></a><a class="top-sign" href="#" data-toggle="modal" data-target="#myModal5"></a>
                                            <div id="loginBox">  
                                                <form action="login" method="post" id="loginForm">


                                                    <fieldset id="body">
                                                        <fieldset>
                                                            <label>Username = ${loggeduser.getName()}</label>

                                                        </fieldset>
                                                        <fieldset>
                                                            <label>Email = ${loggeduser.getGmail()}</label>

                                                        </fieldset>

                                                    </fieldset>
                                                    <input type="submit" name ="action" id="setting" value="Setting">
                                                    <input type="submit" name="action" value="Log out" id="login">

                                                </form>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <!-------->
                    </div>
                    <div class="clearfix"></div>
                </div>

                <div id="page-wrapper">
                    <div class="inner-content">
                        <!--//music-left-->
                        <div class="music-left">
                            <div class="profile">
                                <h2>${loggeduser.getName()}</h2>
                                <h3>Email: ${loggeduser.getGmail()}</h3>
                                <h3>${loggeduser.getInfor()}</h3>
                                <h3>${loggeduser.getImage()}</h3>
                                <img src="${loggeduser.getImage()}">
                            </div>
                        </div>
                        <!--//music-left-->
                        <!--/music-right-->
                        <div class="music-right">
                            <!--/video-main-->
                            <div class="video-main">
                                <div class="video-record-list">
                                    <div id="jp_container_1" class="jp-video jp-video-270p" role="application" aria-label="media player">
                                        <div class="jp-type-playlist">
                                            <div id="jquery_jplayer_1" class="jp-jplayer" style="width: 480px; height: 270px;"><img id="jp_poster_0" src="video/play1.png" style="width: 480px; height: 270px; display: inline;"><video id="jp_video_0" preload="metadata" src="http://192.168.30.9/vijayaa/2015/Dec/mosaic/web/video/Ellie-Goulding.webm" title="1. Ellie-Goulding" style="width: 0px; height: 0px;"></video></div>
                                            <div class="jp-gui">
                                                <div class="jp-video-play" style="display: block;">
                                                    <button class="jp-video-play-icon" role="button" tabindex="0">play</button>
                                                </div>
                                                <div class="jp-interface">
                                                    <div class="jp-progress">
                                                        <div class="jp-seek-bar" style="width: 100%;">
                                                            <div class="jp-play-bar" style="width: 0%;"></div>
                                                        </div>
                                                    </div>
                                                    <div class="jp-current-time" role="timer" aria-label="time">00:00</div>
                                                    <div class="jp-duration" role="timer" aria-label="duration">00:18</div>
                                                    <div class="jp-controls-holder">
                                                        <div class="jp-controls">
                                                            <button class="jp-previous" role="button" tabindex="0">previous</button>
                                                            <button class="jp-play" role="button" tabindex="0">play</button>
                                                        </div>
                                                        <div class="jp-volume-controls">
                                                            <button class="jp-mute" role="button" tabindex="0">mute</button>
                                                            <button class="jp-volume-max" role="button" tabindex="0">max volume</button>
                                                            <div class="jp-volume-bar">
                                                                <div class="jp-volume-bar-value" style="width: 100%;"></div>
                                                            </div>
                                                        </div>
                                                        <div class="jp-toggles">

                                                            <button class="jp-full-screen" role="button" tabindex="0">full screen</button>
                                                        </div>
                                                    </div>
                                                    <div class="jp-details" style="display: none;">
                                                        <div class="jp-title" aria-label="title">1. Ellie-Goulding</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="jp-playlist">
                                                <ul style="display: block;"><li class="jp-playlist-current"><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item jp-playlist-current" tabindex="0">1. Ellie-Goulding <span class="jp-artist">by Pixar</span></a></div></li><li><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item" tabindex="0">2. Mark-Ronson-Uptown <span class="jp-artist">by Pixar</span></a></div></li><li><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item" tabindex="0">3. Ellie-Goulding <span class="jp-artist">by Pixar</span></a></div></li><li><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item" tabindex="0">4. Maroon-Sugar <span class="jp-artist">by Pixar</span></a></div></li><li><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item" tabindex="0">5. Pharrell-Williams <span class="jp-artist">by Pixar</span></a></div></li><li><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item" tabindex="0">6. Ellie-Goulding <span class="jp-artist">by Pixar</span></a></div></li><li><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item" tabindex="0">7. Pharrell-Williams <span class="jp-artist">by Pixar</span></a></div></li></ul>
                                            </div>
                                            <div class="jp-no-solution" style="display: none;">
                                                <span>Update Required</span>
                                                To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- script for play-list -->
                            <link href="css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css">
                            <script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
                            <script type="text/javascript" src="js/jplayer.playlist.min.js"></script>
                            <script type="text/javascript">
                                    //<![CDATA[
                                    $(document).ready(function () {

                                        new jPlayerPlaylist({
                                            jPlayer: "#jquery_jplayer_1",
                                            cssSelectorAncestor: "#jp_container_1"
                                        }, [

                                            {
                                                title: "1. Ellie-Goulding",
                                                artist: "",
                                                mp4: "video/Ellie-Goulding.mp4",
                                                ogv: "video/Ellie-Goulding.ogv",
                                                webmv: "video/Ellie-Goulding.webm",
                                                poster: "video/play1.png"
                                            },
                                            {
                                                title: "2. Mark-Ronson-Uptown",
                                                artist: "",
                                                mp4: "video/Mark-Ronson-Uptown.mp4",
                                                ogv: "video/Mark-Ronson-Uptown.ogv",
                                                webmv: "video/Mark-Ronson-Uptown.webm",
                                                poster: "video/play2.png"
                                            },
                                            {
                                                title: "3. Ellie-Goulding",
                                                artist: "",
                                                mp4: "video/Ellie-Goulding.mp4",
                                                ogv: "video/Ellie-Goulding.ogv",
                                                webmv: "video/Ellie-Goulding.webm",
                                                poster: "video/play1.png"
                                            },
                                            {
                                                title: "4. Maroon-Sugar",
                                                artist: "",
                                                mp4: "video/Maroon-Sugar.mp4",
                                                ogv: "video/Maroon-Sugar.ogv",
                                                webmv: "video/Maroon-Sugar.webm",
                                                poster: "video/play4.png"
                                            },
                                            {
                                                title: "5. Pharrell-Williams",
                                                artist: "",
                                                mp4: "video/Pharrell-Williams.mp4",
                                                ogv: "video/Pharrell-Williams.ogv",
                                                webmv: "video/Pharrell-Williams.webm",
                                                poster: "video/play5.png"
                                            },
                                            {
                                                title: "6. Ellie-Goulding",
                                                artist: "",
                                                mp4: "video/Ellie-Goulding.mp4",
                                                ogv: "video/Ellie-Goulding.ogv",
                                                webmv: "video/Ellie-Goulding.webm",
                                                poster: "video/play1.png"
                                            },
                                            {
                                                title: "7. Pharrell-Williams",
                                                artist: "",
                                                mp4: "video/Pharrell-Williams.mp4",
                                                ogv: "video/Pharrell-Williams.ogv",
                                                webmv: "video/Pharrell-Williams.webm",
                                                poster: "video/play5.png"
                                            }
                                        ], {
                                            swfPath: "../../dist/jplayer",
                                            supplied: "webmv,ogv,mp4",
                                            useStateClassSkin: true,
                                            autoBlur: false,
                                            smoothPlayBar: true,
                                            keyEnabled: true
                                        });

                                    });
                                    //]]>
                            </script>
                            <!-- //script for play-list -->
                            <!--//video-main-->
                        </div>
                    </div>
                    <!--//music-right-->
                    <div class="clearfix"></div>
                    <!-- /w3l-agile-its -->
                </div>
                <!--body wrapper start-->

                <div class="review-slider">
                    <div class="tittle-head">
                        <h3 class="tittle">Featured Albums <span class="new"> New</span></h3>
                        <div class="clearfix"> </div>
                    </div>
                    <ul id="flexiselDemo1">
                        <li>
                            <a href="single.html"><img src="images/v1.jpg" alt=""/></a>
                            <div class="slide-title"><h4>Adele21 </div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="single.html"><img src="images/v2.jpg" alt=""/></a>
                            <div class="slide-title"><h4>Adele21</h4></div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="single.html"><img src="images/v3.jpg" alt=""/></a>
                            <div class="slide-title"><h4>Shomlock</h4></div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="single.html"><img src="images/v4.jpg" alt=""/></a>
                            <div class="slide-title"><h4>Stuck on a feeling</h4></div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="single.html"><img src="images/v5.jpg" alt=""/></a>
                            <div class="slide-title"><h4>Ricky Martine </h4></div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="single.html"><img src="images/v6.jpg" alt=""/></a>
                            <div class="slide-title"><h4>Ellie Goluding </h4></div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="single.html"><img src="images/v6.jpeg" alt=""/></a>
                            <div class="slide-title"><h4>Fifty Shades </h4></div>
                            <div class="date-city">
                                <h5>Jan-02-16</h5>
                                <div class="buy-tickets">
                                    <a href="single.html">READ MORE</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <script type="text/javascript">
                        $(window).load(function () {

                            $("#flexiselDemo1").flexisel({
                                visibleItems: 5,
                                animationSpeed: 1000,
                                autoPlay: true,
                                autoPlaySpeed: 3000,
                                pauseOnHover: false,
                                enableResponsiveBreakpoints: true,
                                responsiveBreakpoints: {
                                    portrait: {
                                        changePoint: 480,
                                        visibleItems: 2
                                    },
                                    landscape: {
                                        changePoint: 640,
                                        visibleItems: 3
                                    },
                                    tablet: {
                                        changePoint: 800,
                                        visibleItems: 4
                                    }
                                }
                            });
                        });
                    </script>
                    <script type="text/javascript" src="js/jquery.flexisel.js"></script>	
                </div>
            </div>
            <div class="clearfix"></div>
            <!--body wrapper end-->
        </section>

        <script src="js/jquery.nicescroll.js"></script>
        <script src="js/scripts.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.js"></script>
    </body>
</html>
