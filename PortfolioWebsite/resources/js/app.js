$(document).ready(function() {
    
    var navigation = (function() {
        /* For the mobile navigation */
        $('.ion-navicon-round').click(function() {
            if ($('.ion-navicon-round').hasClass('ion-navicon-round')) {
                $('.ion-navicon-round').addClass('ion-close-round');
                $('.ion-navicon-round').removeClass('ion-navicon-round');

                $('.mobile-nav').css('height', '160');
                $('.mobile-nav li').css('display', 'block');

            } else if ($('.ion-close-round').hasClass('ion-close-round')) {
                $('.ion-close-round').addClass('ion-navicon-round');
                $('.ion-close-round').removeClass('ion-close-round');

                $('.mobile-nav').css('height', '40');
                $('.mobile-nav li').css('display', 'none');
            }
        });

        $('.mobile-nav li a').on('click', function(){
            if ($('.ion-navicon-round').hasClass('ion-navicon-round')) {
                $('.ion-navicon-round').addClass('ion-close-round');
                $('.ion-navicon-round').removeClass('ion-navicon-round');

                $('.mobile-nav').css('height', '160');
                $('.mobile-nav li').css('display', 'block');

            } else if ($('.ion-close-round').hasClass('ion-close-round')) {
                $('.ion-close-round').addClass('ion-navicon-round');
                $('.ion-close-round').removeClass('ion-close-round');

                $('.mobile-nav').css('height', '40');
                $('.mobile-nav li').css('display', 'none');
            }
        });

        /* For the sticky navigation */
        $('#about-me-anchor').waypoint(function(direction) {

            var stickyDiv = document.querySelector('.sticky-div-display');
            var stickyNav = document.querySelector('.sticky-div-display nav');

            if (direction == "down") {
                stickyDiv.classList.add("sticky-div-background");
                stickyDiv.classList.remove("hide-sticky")
                stickyNav.classList.remove("nav-toggle");
            } else {           
                stickyDiv.classList.remove("sticky-div-background");
                stickyDiv.classList.add("hide-sticky")
                stickyNav.classList.add("nav-toggle");
            }
        }, {
          offset: '60px;'
        });
    });

    var smoothScrolling = (function() {
        // Select all links with hashes
        $('a[href*="#"]')
          // Remove links that don't actually link to anything
          .not('[href="#"]')
          .not('[href="#0"]')
          .click(function(event) {
            // On-page links
            if (
              location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') 
              && 
              location.hostname == this.hostname
            ) {
              // Figure out element to scroll to
              var target = $(this.hash);
              target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
              // Does a scroll target exist?
              if (target.length) {
                // Only prevent default if animation is actually gonna happen
                event.preventDefault();
                $('html, body').animate({
                  scrollTop: target.offset().top
                }, 1000, function() {
                  // Callback after animation
                  // Must change focus!
                  var $target = $(target);
                  $target.focus();
                  if ($target.is(":focus")) { // Checking if the target was focused
                    return false;
                  } else {
                    $target.attr('tabindex','-1'); // Adding tabindex for elements not focusable
                    $target.focus(); // Set focus again
                  };
                });
              }
            }
          });
    });
    
    var progressBars = (function () {
        var id = document.querySelectorAll('.skill-bar');
        
        for (var i = 0; i < id.length;  i++) {        
            
            new Waypoint({
                element: document.getElementById(id[i].id),
                handler: function(direction) { 
                    move(this.element);       
                    this.destroy();
                },
                offset: 'bottom-in-view'
            });
            
            function move(elem) {
                this.elem = elem; 
                var width = 1;
                var interval = 10;
                var id = setInterval(frame, interval);
                function frame() {

                    var index = 0;
                    var percentsComplete = [90, 85, 85, 65, 90, 80, 75, 85, 70, 75, 80];
                    
                    switch(elem.getAttribute('id')) {
                        case 'java-bar':
                            index = 0;
                            break;
                        case 'springmvc-bar':
                            index = 1;
                            break;
                        case 'springboot-bar':
                            index = 2;
                            break;
                        case 'springsecurity-bar':
                            index = 3;
                            break;
                        case 'html-css-bar':
                            index = 4;
                            break;
                        case 'javascript-bar':
                            index = 5;
                            break;
                        case 'jquery-bar':
                            index = 6;
                            break;
                        case 'sql-bar':
                            index = 7;
                            break;
                        case 'jpa-hibernate-bar':
                            index = 8;
                            break;
                            case 'jdbc-template-bar':
                            index = 9;
                            break;
                            case 'junit-bar':
                            index = 10;
                            break;
                        default: 
                            index = 0;
                            break;
                    }
                    
                    if (width + (.1 * width) >= percentsComplete[index]) {
                        clearInterval(id);
                    } else {
                        width++; 
                        elem.style.width = width + '%'; 
                    }
                }
            } 
        }
    });

    var animations = (function() {
        var animationOffset = '99%';
        
        $('#resume-button-animate').addClass('animated rubberBand');

        /* Animations on scroll */
        $('.about-me-animate').waypoint(function(direction) {

            $('.about-me-animate').addClass('animated slideInUp');
        }, {
            offset: animationOffset
        });

        /* Animations on scroll */
        $('.certifications-animate').waypoint(function(direction) {
            $('.certifications-animate').addClass('animated bounceInUp');
        }, {
            offset: animationOffset
        });

        /* Animations on scroll */
        $('footer .wrapper .social').waypoint(function(direction) {
            $('footer .wrapper .social').addClass('animated swing');
        }, {
            offset: animationOffset
        });
    });

    navigation();
    smoothScrolling();
    progressBars();
    animations();
       
});


