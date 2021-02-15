<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="main.jsp" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
<script>
  AOS.init();
  $(function(){
		$.ajax({		
			type:'post',
			url:'<%=request.getContextPath()%>/NoticeContentServlet',
			dataType : "json",
			success : function(result) {
				console.log(result);
				console.log('ajax GET 통신 성공');
				for (let i = 0; i < 4; i++) {
	                let li = document.createElement('li');
	                document.getElementById("show").append(li);
	                let a = document.createElement('a');
	                li.append(a);
	                for(field in result[i]){
	                	if([field] == "nContent"){
	                		console.log("테스트: " + result[i][field]);
	                		let span = document.createElement('span');
	                		$(span).attr('class','notice_contents');
	                		span.innerHTML = result[i][field];
	                		a.append(span);
	                	}else if([field] == "nDate"){
	                		let span = document.createElement('span');
	                		$(span).attr('class','notice_date');
	                		span.innerHTML = result[i][field];
	                		a.append(span);
	                		console.log("테스트: " + result[i][field]);
	                	}else if([field] == "nNumber"){
	                		let input = document.createElement('input');
	                		$(input).attr('name', field);
	                		$(input).attr('id', field);
	                		$(input).attr('type', "hidden");
	                		input.value = result[i][field];
	                		a.append(input);
	                		console.log("테스트: " + result[i][field]);	                		
	                	}
	                }
              }

				function fn_article3(containerID, buttonID, autoStart){
					var $element = $('#'+containerID).find('.notice-list');
					var autoPlay = autoStart;
					var auto = null;
					var speed = 3000;
					var timer = null;

					var move = $element.children().outerHeight();
					var first = false;
					var lastChild;

					lastChild = $element.children().eq(-1).clone(true);
					lastChild.prependTo($element);
					$element.children().eq(-1).remove();

					if($element.children().length==1){
						$element.css('top','0px');
					}else{
						$element.css('top','-'+move+'px');
					}

					if(autoPlay){
						timer = setInterval(moveNextSlide, speed);
						auto = true;
					}else{
						$play.hide();
						$stop.hide();
					}

					$element.find('>li').bind({
						'mouseenter': function(){
							if(auto){
								clearInterval(timer);
							}
						},
						'mouseleave': function(){
							if(auto){
								timer = setInterval(moveNextSlide, speed);
							}
						}
					});

					function movePrevSlide(){
						$element.each(function(idx){
							if(!first){
								$element.eq(idx).animate({'top': '0px'},'normal',function(){
									lastChild = $(this).children().eq(-1).clone(true);
									lastChild.prependTo($element.eq(idx));
									$(this).children().eq(-1).remove();
									$(this).css('top','-'+move+'px');
								});
								first = true;
								return false;
							}

							$element.eq(idx).animate({'top': '0px'},'normal',function(){
								lastChild = $(this).children().filter(':last-child').clone(true);
								lastChild.prependTo($element.eq(idx));
								$(this).children().filter(':last-child').remove();
								$(this).css('top','-'+move+'px');
							});
						});
					}

					function moveNextSlide(){
						$element.each(function(idx){

							var firstChild = $element.children().filter(':first-child').clone(true);
							firstChild.appendTo($element.eq(idx));
							$element.children().filter(':first-child').remove();
							$element.css('top','0px');

							$element.eq(idx).animate({'top':'-'+move+'px'},'normal');

						});
					}
				}  
				jQuery(function(){
					var $ = jQuery;
				  jQuery('.btn').addClass('pointer').click(function () {
				   var ih = $(this).index() == 0 ? -18 : 18; //위아래로 움직이는 px 숫자
				   var obj = $('.recommend_list');
				   obj.animate({ scrollTop:obj.scrollTop() + ih }, 100);
				  });
				});
				jQuery(function(){
				  function fn_article(container,btn, auto){}
				});
				fn_article3('notice5','bt5',true);

			}
		})
	})
	$(function(){
		$("#show").on('click', $('li'), function(e){
			let td = $(e.target).parentsUntil('div').find("[type='hidden']").eq(1).val();//.parentNode.childNodes[0].value;
			let nDate = $(e.target).parentsUntil('div').find("span").eq(1)[0].innerHTML;//val();//.parentNode.childNodes[0].value;
			console.log(nDate);
		 	location.href = "noticeView.do?nDate=" + nDate;
		})		
	})
</script>
<div id="main">
        	<div id="main_text" data-aos="fade-up" data-aos-delay="00" data-aos-duration="900"><img src="image/text.png">
        		<p>당신의 믿을 수 있는 중고거래를 위해 <br>
					지금 이 순간에도 노력하고 있습니다.</p>
        	</div>
			<div data-aos="fade-up" data-aos-delay="300" data-aos-duration="900">
				<button id="button" onclick="location.href='boardList.do'"><span>MORE </span></button>
			</div>
</div>

<div class="news" id="notice5">
	<div class="notice_icon" align="left">
		<img src="image/notice.png" >
	</div>
	<div class="open-event fl">
		<ul class="notice-list" id="show">
		</ul>
	</div>
</div>
<script>
</script>

<!-- include -->

 </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

            


        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>



    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>