<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
%>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"/> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"/> 
<META HTTP-EQUIV="Expires" CONTENT="0"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/default.css"/>
<link rel="stylesheet" href="${ctx }/resources/css/locus.css"/>
<link rel="stylesheet" type="text/css" href="${ctx }/resources/css/font-awesome/css/font-awesome.min.css">
<%-- <link rel="stylesheet" type="text/css" href="${ctx }/resources/js/jeasyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/js/jeasyui/themes/icon.css" /> --%>
<link rel="stylesheet" type="text/css" href="${ctx }/resources/js/easyui1.4.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/js/easyui1.4.3/themes/icon.css" />
<!-- JavaScript -->
<%-- <script type="text/javascript" src="${ctx }/resources/js/jeasyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/jeasyui/locale/easyui-lang-zh_CN.js"></script> --%>

<script type="text/javascript" src="${ctx }/resources/js/easyui1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/easyui1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/easyui1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/tools/moment.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/common.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/json2.js"></script>



