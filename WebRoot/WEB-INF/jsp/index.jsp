<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>广东药科大学</title>
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
 <link href="${pageContext.request.contextPath}/css/MainFram.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="./网上商城/index.htm"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg"
					alt="广东药科大学" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<input id="inp_search_product" class="form-control" type="text" placeholder="商品搜索"/>
				<button id="btn_search_product" class="btn btn-primary" onclick="search_product(1)">search</button>
			</div>
		</div>
	<%@ include file="menu.jsp" %>
	</div>
	<div class="container index">
		<div class="span24">
		<!-- 轮播图 -->
		<div class="flash">
    	<!-- 图片展示 -->
        <ul class="con">
        	<li style="background-image:url(images/img1.jpg)"></li>
            <li style="background-image:url(images/img2.jpg)"></li>
            <li style="background-image:url(images/img3.jpg)"></li>
            <li style="background-image:url(images/img4.jpg)"></li>
        </ul>
        <!-- 图片按钮 -->
        <ul class='but'>
			<li class="current"></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
    </div>
		</div>

		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong>热门商品</strong>
				</div>
				<ul class="tabContent" style="display: block;">
					<s:iterator var="p" value="productList">
					<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value='#p.pid'/>"><img
							src="${pageContext.request.contextPath}/<s:property value='#p.image'/>"
							style="display: block;"></a>
					</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong> <a target="_blank"></a>
				</div>
				<ul class="tabContent" style="display: block;">
				<s:iterator var="newestProduct" value="newestProductList">
					<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value='#newestProduct.pid'/>"><img
							src="${pageContext.request.contextPath}/<s:property value='#newestProduct.image'/>"
							data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg"
							style="display: block;"></a></li>
				</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>新手指南</dt>
					<dd>
						<a target="_blank">支付方式</a> |
					</dd>
					<dd>
						<a target="_blank">配送方式</a> |
					</dd>
					<dd>
						<a target="_blank">售后服务</a> |
					</dd>
					<dd>
						<a target="_blank">购物帮助</a> |
					</dd>
					
					<dd>
						<a target="_blank">礼品卡</a> |
					</dd>
					<dd>
						<a target="_blank">银联卡</a> |
					</dd>
					

					<dd class="more">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>招贤纳士</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>服务声明</a> |</li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2017-2018 网上商城 版权所有</div>
		</div>
	</div>
	<script type="text/javascript" color="0,0,255" opacity="1" z-index: 2 count="110" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js">
<canvas style="position: fixed; top: 0px; left: 0px; z-index: 2; opacity: 1;" width="1366" height="297"></canvas>
<script type="text/javascript" alpha="0.2" src="http://cdn.atool.org/res/ribbon.min.js">
<canvas width="1366" height="635" style="position: fixed; top: 0px; left: 0px; z-index: 2; width: 100%; height: 100%; pointer-events: none;"></canvas>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/LunBoTu.js"></script>
</html>