(function($) {
	//日期
	var ISODateRegExp = new RegExp("^[1-2]\\d{3}-(0?[1-9]||1[0-2])-(0?[1-9]||[1-2][0-9]||3[0-1])$");
	
	//比较两日期   add wxsong
	
	function compareDate(DateOne,DateTwo){ 
		var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ("-")); 
		var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ("-")+1); 
		var OneYear = DateOne.substring(0,DateOne.indexOf ("-")); 
		var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ("-")); 
		var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ("-")+1); 
		var TwoYear = DateTwo.substring(0,DateTwo.indexOf ("-")); 
		if (Date.parse(OneMonth+"/"+OneDay+"/"+OneYear) > Date.parse(TwoMonth+"/"+TwoDay+"/"+TwoYear)) { 
			return true;//dataone>datetwo 
		}else { 
			return false; 
		} 
	} 
	function compareDate2(DateOne,DateTwo) 
	{ 
		var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ("-")); 
		var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ("-")+1); 
		var OneYear = DateOne.substring(0,DateOne.indexOf ("-")); 
		var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ("-")); 
		var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ("-")+1); 
		var TwoYear = DateTwo.substring(0,DateTwo.indexOf ("-")); 
		if (Date.parse(OneMonth+"/"+OneDay+"/"+OneYear)<Date.parse(TwoMonth+"/"+TwoDay+"/"+TwoYear)) 
			{ return true;//dataone>datetwo 
			}
		else 
		    { return false; } 
			
	} 
	function compareDateLessThan(DateOne,DateTwo) 
	{ 
		var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ("-")); 
		var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ("-")+1); 
		var OneYear = DateOne.substring(0,DateOne.indexOf ("-")); 
		var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ("-")); 
		var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ("-")+1); 
		var TwoYear = DateTwo.substring(0,DateTwo.indexOf ("-")); 
		if (Date.parse(OneMonth+"/"+OneDay+"/"+OneYear) >= Date.parse(TwoMonth+"/"+TwoDay+"/"+TwoYear)) 
		{ 
			return true;//dataone>datetwo 
		}
		else 
		{ 
			return false;
		} 
		
	} 
	
	//利率和金额
	//PercentageRate
	var PercentageRateRegExp = /^(\d{1})|(\d{2}\.\d{0,6})|(\.\d{1,6})$/;
	//可大于100%的收益率
	var BigPercentageRateRegExp = /^(\d{17})|(\d{10}\.\d{0,6})|(\.\d{1,6})$/;
	//CurrencyAndAmount
	var CurrencyAndAmountRegExp = /^(\d{1,18})|(\d{1,18}\.)|(\d{1,17}\.\d{0,1})|(\d{1,16}\.\d{0,2})|(\.\d{1,2})$/;
	var CurrencyAndAmountCanBeNegativeRegExp = /^\-?(\d{1,18})|(\d{1,18}\.)|(\d{1,17}\.\d{0,1})|(\d{1,16}\.\d{0,2})|(\.\d{1,2})$/;
	var checkCurrencyAndAmountRegExp = /^(0|[1-9])|(0|[1-9]\.)$/;
	//组织机构代码
	var CmonCdRegExp = new RegExp("^[\\-a-zA-Z0-9]{1,10}$");
	//校验0-100的比例的校验
	var NormalProportionRegExp = /^(0|100|\d{1,2})$/;
	//电子邮件的校验
	var eMailRegExp = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; 
	//身份证
	var idCardRegExp =/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$/;
	$.checkStringLength = function (checkVale, maxLength, fixedLength) { 
		//检查字符串长度
		var totalLength = checkVale.length;
		//当填写的字符数小于设置的字符数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		//当填写的字符数小于设置的字符数 
		else if(totalLength * 1 > maxLength * 1) {
			return false;
		}
		//当填写的字符必须定长
		else if(fixedLength == true && totalLength * 1 != maxLength * 1){
			return false;
		}
		
		return true; 
	},
	
	$.checkNumericLength = function (checkVale, maxLength, fixedLength) { 
		
		//检查字符串只为数字
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {

			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[0-9]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2;
				return false;
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		//当填写的字节数小于设置的字节数 
		else if(totalLength * 1 > maxLength * 1){
			return false;
		}
		//当填写的字符必须定长
		else if(fixedLength == true && totalLength * 1 != maxLength * 1){
			return false;
		}
		
		return true; 
	},
	
	$.checkNumericLength1 = function (checkVale, fixedLength) { 
		
		//检查字符串只为数字
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {

			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[0-9]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2;
				return false;
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		
		return true; 
	},
	
	$.checkNumericLength2 = function (checkVale, maxLength, fixedLength) { 
		
		//检查字符串只为数字
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {

			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[0-9]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2;
				return false;
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		
		//当填写的字节数小于设置的字节数 
		else if(totalLength * 1 > maxLength * 1){
			return false;
		}
		
		return true; 
	},
	//只为字母和字符串
	$.checkNumericAndENLength = function (checkVale, fixedLength) { 
		//检查字符串只为数字
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {

			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[A-Za-z0-9]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2;
				return false;
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		
		return true; 
	},
	//不包含特殊字符    汉字字母数字下划线
	$.notSpecial = function (checkVale, fixedLength) { 
		//检查字符串只为数字
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {

			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[\u4E00-\u9FA5a-zA-Z0-9_\(\)]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2;
				return false;
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		
		return true; 
	},
	$.notquanSpecial = function (checkVale, fixedLength) { 
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {
			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[\u4E00-\u9FA5a-zA-Z0-9]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				var   reg=/[^\uFF00-\uFFFF]/g;
			      if   (reg.test(charCode))   { 
			          return   false;   
			      }   else   {
//			    	  alert("全角");
//			          return   false;   
			      }   
			      totalLength+=2;
			}
		}
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		
		return true; 
	},
	$.checkNotCNStringLength  = function (checkVale, maxLength, fixedLength) { 
		
		//检查字符串中是否含有中文字符
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {

			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[\u0000-\u00ff]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2;
				return false;
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		//当填写的字节数小于设置的字节数 
		else if(totalLength * 1 > maxLength * 1){
			return false;
		}
		//当填写的字符必须定长
		else if(fixedLength == true && totalLength * 1 != maxLength * 1){
			return false;
		}
		
		return true; 
	},
	
	$.checkBytesLength = function (checkVale, maxLength, fixedLength) { 
		
		//检查字符串字节长度
		var totalLength = 0;   
		var charCode;
		for (var i = 0; i < checkVale.length; i++) {
			
			
			//UCS-2编码(16进制) UTF-8 字节流(二进制)
			/*charCode = checkVale.charCodeAt(i);
			if (charCode < 0x007f) {   
	            totalLength++;   
			} else if (charCode <= 0x07ff) {   
	            totalLength += 2;   
	        } else if (charCode <= 0xffff) {   
	            totalLength += 3; 
	        } else{
				totalLength += 4; 
			}*/
			
			//普通方式
			charCode = checkVale.charAt(i);
			if (/^[\u0000-\u00ff]$/.test(charCode)) { 
				totalLength++; 
			}
			else { 
				totalLength+=2; 
			}
		}
		
		//当填写的字节数小于设置的字节数 
		if (totalLength * 1 < 1){ 
			return false; 
		} 
		//当填写的字节数小于设置的字节数 
		else if(totalLength * 1 > maxLength * 1){
			return false;
		}
		//当填写的字符必须定长
		else if(fixedLength == true && totalLength * 1 != maxLength * 1){
			return false;
		}
		
		return true; 
	},
	
	$.checkParam = function (param) {
		var pattern = /^\w[\w\d]*?=\w[\w\d]*?(;\w[\w\d]*?=\w[\w\d]*?)*$/;
		if(!pattern.test(param)){
			return false;
		}		
	},
	
	$.checkDate = function (dateStr) { //校验日期函数(正确日期格式：YYYY-MM-DD)
		var year,month,day;
		var isRYear = false;
		var tDate = dateStr.split("-");
		if(!ISODateRegExp.test(dateStr))
			return false;
		if(tDate!=null)
		{
			year = tDate[0];
			month = tDate[1];
			day = tDate[2];
		}
		if(parseInt(day)<0 || parseInt(day)>31 || day.length!=2)
			return false;
		if(parseInt(month)<0 || parseInt(month)>12 || month.length!=2)
			return false;
		if(parseInt(year)%4==0 || parseInt(year)%100==0)
			isRYear = true;
		if(parseInt(month) == 2 && isRYear)
		{
			//if(parseInt(day)>28)
			if(parseInt(day)>29)		//2010年2月9日修正闰年2月天数问题rczhan
				return false;
		}else
		{
			//if(parseInt(month)==2 && parseInt(day)>29 )
			if(parseInt(month)==2 && parseInt(day)>29 )		//2010年2月9日修正闰年2月天数问题rczhan
				return false;	
				
				if(month.substring(0,1)=='0')
				{
					month = month.substring(1,month.length);
				}
			if((parseInt(month)<=7 && parseInt(month)%2==0)||(parseInt(month)>=8 && parseInt(month)%2==1))
			{
				if(parseInt(day)>30)
					return false;
			}	
			
		}
		return true;
	},
	
	$.reverseFormatAmount = function (strData) { //反向格式化金额
		
		var rData = "";
		var strTemp = new String(strData);

		for(var i=0;i<strTemp.length;i++)
		{
			var cData = strTemp.charAt(i);
			if (cData!=",")
			{
				rData = rData+cData;
			}
		}
		return rData;
	},
	
	$.addRegularExpressionFormValidate = function (f, p) {
		var formReturn = true;
		var errorFieldName = new Array();
		var errorMessage = new Array();
		if(p.colModel){
			//值不能为空校验、数据类型校验
			for(var i=0; i<p.colModel.length; i++){
				var _result = true;
				var fieldname = p.colModel[i].fieldName;
				//加上下拉框类型
				var _elements = $('input[name="'+ fieldname +'"],select[name="'+ fieldname +'"],textarea[name="'+ fieldname +'"]', $(f));
				var labelName = '';
				var fixedLength = false;
				if(p.colModel[i].labelName){
					labelName = p.colModel[i].labelName;
				}
				if(p.colModel[i].fixedLength && p.colModel[i].fixedLength == true){
					fixedLength = true;
				}
				//暂时只处理form元素name为一个的情况
				if(_elements && _elements.length == 1){
					var _elementValue = $.trim($(_elements[0]).val());
					//如果是记录跟踪编号，则不需要去掉空格
					if(fieldname == 'ITEM_7641'){
						_elementValue = $(_elements[0]).val();
					}
					//值不能为空校验
					if(p.colModel[i].notNull && p.colModel[i].notNull == true){
						if(_elementValue == ''){
							errorFieldName.push(fieldname);
							errorMessage.push(labelName + "值不能为空");
							_result = false;
						}
					}
					//数据类型校验
					if(_result == true && p.colModel[i].fieldType && _elementValue != ''){
						switch(p.colModel[i].fieldType) {
							case "Max20Text":
								_result = $.checkStringLength(_elementValue, 20, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定20位文本");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长20位文本");
									}
								}
								break;
							case "Max50Text":
								_result = $.checkStringLength(_elementValue,50, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定50位文本");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长50位文本");
									}
								}
								break;
							case "Max100Text":
								_result = $.checkStringLength(_elementValue, 100, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定100位文本");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长100位文本");
									}
								}
								break;
							case "Max200Text":
								_result = $.checkStringLength(_elementValue, 200, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定200位文本");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长200位文本");
									}
								}
								break;	
							case "Max1NumericText":
								_result = $.checkNumericLength(_elementValue, 1, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定1位数字");
									}
									else{
										errorMessage.push(labelName + "值范围为最短1位，最长1位数字");
									}
								}
								break;	
							case "Max2NumericText":
								_result = $.checkNumericLength(_elementValue, 2, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定2位数字");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长2位数字");
									}
								}
								break;
							case "Max3NumericText":
								_result = $.checkNumericLength(_elementValue, 3, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定3位数字");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长3位数字");
									}
								}
								break;
							case "Max4NumericText":
								_result = $.checkNumericLength(_elementValue, 4, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定4位数字");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长4位数字");
									}
								}
								break;
							case "Max6NumericText":
								_result = $.checkNumericLength(_elementValue, 6, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定6位数字");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长6位数字");
									}
								}
								break;
							case "Max10NumericText":
								_result = $.checkNumericLength(_elementValue, 10, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定10位数字");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长10位数字");
									}
								}
								break;
						    case "Max20NumericText":
								_result = $.checkNumericLength(_elementValue, 20, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定20位数字");
									}else{
										errorMessage.push(labelName + "值范围为最短1位，最长20位数字");
									}
								}
								break;
							case "Max1ANText":
								_result = $.checkNotCNStringLength(_elementValue, 1, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定1位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长1位字符");
									}
								}
								break;
							case "Max3ANText":
								_result = $.checkNotCNStringLength(_elementValue, 3, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定3位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长3位字符");
									}
								}
								break;
							case "Max5ANText":
								_result = $.checkNotCNStringLength(_elementValue, 5, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定5位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长5位字符");
									}
								}
								break;	
							case "Max10ANText":
								_result = $.checkNotCNStringLength(_elementValue, 10, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定10位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长10位字符");
									}
								}
								break;
							case "Max16ANText":
								_result = $.checkNotCNStringLength(_elementValue, 16, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定16位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长16位字符");
									}
								}
								break;
							case "Max18ANText":
								_result = $.checkNotCNStringLength(_elementValue, 18, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定18位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长18位字符");
									}
								}
								break;
							case "Max20ANText":
								_result = $.checkNotCNStringLength(_elementValue, 20, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定20位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长20位字符");
									}
								}
								break;
							case "Max25ANText":
								_result = $.checkNotCNStringLength(_elementValue, 25, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定25位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长25位字符");
									}
								}
								break;
							case "Max30ANText":
								_result = $.checkNotCNStringLength(_elementValue, 30, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定30位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长30位字符");
									}
								}
								break;
							case "Max35ANText":
								_result = $.checkNotCNStringLength(_elementValue, 35, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定35位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长35位字符");
									}
								}
								break;
							case "Max50ANText":
								_result = $.checkNotCNStringLength(_elementValue, 50, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定50位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长50位字符");
									}
								}
								break;
							case "Max100ANText":
								_result = $.checkNotCNStringLength(_elementValue, 100, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定100位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长100位字符");
									}
								}
								break;
							case "Max255ANText":
								_result = $.checkNotCNStringLength(_elementValue, 100, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值固定255位字符");
									}else{
										errorMessage.push(labelName + "包含0-9的数字和不包括汉字及全角字符在内的其他字符值最短1位，最长255位字符");
									}
								}
								break;
							case "Max10Bytes":
								_result = $.checkBytesLength(_elementValue, 10, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定10位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长10位的字符");
									}
								}
								break;
							case "Max20Bytes":
								_result = $.checkBytesLength(_elementValue, 20, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定20位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长20位的字符");
									}
								}
								break;
							case "Max30Bytes":
								_result = $.checkBytesLength(_elementValue, 30, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定30位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长30位的字符");
									}
								}
								break;
							case "Max35Bytes":
								_result = $.checkBytesLength(_elementValue, 35, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定35位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长35位的字符");
									}
								}
								break;
							case "Max60Bytes":
								_result = $.checkBytesLength(_elementValue, 60, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定60位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长60位的字符");
									}
								}
								break;
							case "Max80Bytes":
								_result = $.checkBytesLength(_elementValue, 80, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定80位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长80位的字符");
									}
								}
								break;
							case "Max100Bytes":
								_result = $.checkBytesLength(_elementValue, 100, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定100位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长100位的字符");
									}
								}
								break;
							case "Max200Bytes":
								_result = $.checkBytesLength(_elementValue, 200, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定250位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长250位的字符");
									}
								}
								break;
							case "Max250Bytes":
								_result = $.checkBytesLength(_elementValue, 250, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定250位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长250位的字符");
									}
								}
								break;
							case "Max300Bytes":
								_result = $.checkBytesLength(_elementValue, 300, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定300位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长300位的字符");
									}
								}
								break;
							case "Max400Bytes":
								_result = $.checkBytesLength(_elementValue, 400, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "包含汉字在内的所有字符值固定400位的字符");
									}else{
										errorMessage.push(labelName + "包含汉字在内的所有字符值最短1位，最长400位的字符");
									}
								}
								break;
							case "ISODate":
								_result = $.checkDate(_elementValue);
								if(_result == false){
									errorMessage.push(labelName + "格式或者日期不正确，(正确格式为YYYY-MM-DD)");
								}
							break;
							case "PercentageRate":
								_result = $.checkStringLength(_elementValue, 9, fixedLength);
								if(_result == false){
									errorMessage.push(labelName + "值范围为7位数字，小数部分6位");
								}else{
									_result = PercentageRateRegExp.test($.reverseFormatAmount(_elementValue));
									if(_result == false){
										errorMessage.push(labelName + "值范围为7位数字，小数部分6位");
									}
								}
								break;
							case "BigPercentageRate":
								_result = $.checkStringLength(_elementValue, 17, fixedLength);
								if(_result == false){
									errorMessage.push(labelName + "值范围为16位数字，小数部分6位");
								}else{
									_result = BigPercentageRateRegExp.test($.reverseFormatAmount(_elementValue));
									if(_result == false){
										errorMessage.push(labelName + "值范围为20位数字，小数部分6位");
									}
								}
								break;
							case "BigPercentageRateCanBeNegative":
								if(_elementValue.indexOf('-') == 0){
									_elementValue = _elementValue.replace('-','');
								}
								_result = $.checkStringLength(_elementValue, 17, fixedLength);
								if(_result == false){
									errorMessage.push(labelName + "值范围为16位数字，小数部分6位");
								}else{
									_result = BigPercentageRateRegExp.test($.reverseFormatAmount(_elementValue));
									if(_result == false){
										errorMessage.push(labelName + "值范围为20位数字，小数部分6位");
									}
								}
								break;
							case "CurrencyAndAmount":
								//先格式化
								_elementValue = $.reverseFormatAmount(_elementValue);
								_result = $.checkStringLength(_elementValue, 20, fixedLength);
								if(_result == false){
									errorMessage.push(labelName + "值范围为总长20位，最多2位小数");
								}else {
									_result = checkCurrencyAndAmountRegExp.test(_elementValue);
									if(_result == false){
										errorMessage.push(labelName + "值只能输入数字");
									}else{
										_result = CurrencyAndAmountRegExp.test(_elementValue);
										if(_result == false){
											errorMessage.push(labelName + "值范围为总长20位，最多2位小数");
										}
									}
								}
								break;
							case "CurrencyAndAmountCanBeNegative":
								if(_elementValue.indexOf('-') == 0){
									_elementValue = _elementValue.replace('-','');
								}
								//先格式化
								_elementValue = $.reverseFormatAmount(_elementValue);
								_result = $.checkStringLength(_elementValue, 20, fixedLength);
								if(_result == false){
									errorMessage.push(labelName + "值范围为总长20位，最多2位小数");
								}else{
									_result = checkCurrencyAndAmountRegExp.test(_elementValue);
									if(_result == false){
										errorMessage.push(labelName + "值只能输入数字");
									}else{
										_result = CurrencyAndAmountRegExp.test(_elementValue);
										if(_result == false){
											errorMessage.push(labelName + "值范围为总长20位，最多2位小数");
										}
									}
								}
								break;
							case "CurrencyAndAmountGreaterThanZero":
								//先格式化
								_elementValue = $.reverseFormatAmount(_elementValue);
								_result = $.checkStringLength(_elementValue, 20, fixedLength);
								if(_result == false){
									errorMessage.push(labelName + "值范围为总长20位，最多2位小数");
								}else {
									_result = checkCurrencyAndAmountRegExp.test(_elementValue);
									if(_result == false){
										errorMessage.push(labelName + "值只能输入数字");
									}else{
										_result = CurrencyAndAmountRegExp.test(_elementValue);
										if(_result == false){
											errorMessage.push(labelName + "值范围为总长20位，最多2位小数");
										}else{
											if(parseFloat(_elementValue)<=0){
												errorMessage.push(labelName + "输入的值应该大于0");
											}
										}
									}
									
								}
								break;
							case "CmonCd":
								_result = CmonCdRegExp.test(_elementValue);
								if(_result == false){
									errorMessage.push(labelName + "值范围为a-z,A-Z,0-9或“-”号，最短1位，最长10位文本");
								}
								break;
							case "EMail":
								_result = eMailRegExp.test(_elementValue);
								if(_result == false){
									errorMessage.push(labelName + "不符合电子邮件格式");
								}
								break;
							case "IdCard":
								_result = idCardRegExp.test(_elementValue);
								if(_result == false){
									errorMessage.push(labelName + "不符合身份证格式");
								}
								break;
							case "FormatParam":
								_result = $.checkParam(_elementValue);
								if(_result == false){
									errorMessage.push(labelName + "值格式不正确");
								}
								break;
							case "Magnifier":
								if(p.colModel[i].hidname){
									var formel = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() == ''){
												_result = false;
											}
										});
									}
								}
								if(_result == false){
									errorMessage.push(labelName + "请从放大镜中选择！");
								}
								break;
							case "DateNOtMoreThanCurrDate":
								if(p.colModel[i].fieldName){
									var myDate =new Date();
									var currentDate=(myDate.toLocaleDateString().replace(/年|月/g,'-')).replace(/日/g,'');
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												var date=$(fn).val();
												var flag=compareDate(date,currentDate.substring(0, 10));
												if(flag==true){
													_result = false;
												}
											}
										});
									}
								}
								if(_result == false){
									errorMessage.push(labelName + "不能大于当前日期");
								}
								break;
								//不小于当前日期--用于应收支票入库-新增
							case "DateNOtMoreThanCurrDate1":
								if(p.colModel[i].fieldName){
									var myDate =new Date();
									var currentDate=(myDate.toLocaleDateString().replace(/年|月/g,'-')).replace(/日/g,'');
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												var date=$(fn).val();
												var flag=compareDate2(date,currentDate.substring(0, 10));
												if(flag==true){
													_result = false;
												}
											}
										});
									}
								}
								if(_result == false){
									errorMessage.push(labelName + "不能小于当前日期");
								}
								break;
								//小于当前日期
							case "DateLessThanCurrDate":
								if(p.colModel[i].fieldName){
									var myDate =new Date();
									var currentDate=(myDate.toLocaleDateString().replace(/年|月/g,'-')).replace(/日/g,'');
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												var date=$(fn).val();
												var flag=compareDateLessThan(date,currentDate.substring(0, 10));
												if(flag==true){
													_result = false;
												}
											}
										});
									}
								}
								if(_result == false){
									errorMessage.push(labelName + "应小于当前日期");
								}
								break;
							//两个金额比较大小：A不大于B
							case "FromAmountNOtMoreThanToAmount":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									var fromamount="";
									var toamount="";
									
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												fromamount=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												toamount=$(fn).val();
											}
										});
									}
									var flag=true;
									if((fromamount*1-toamount*1)>0){
										_result = false;
									}
									if(toamount==""){
										_result = true;
									}
								}
								if(_result == false){
									errorMessage.push(labelName1 + "不能大于"+labelName2);
								}
								break;
							case "ToAmountNOtLessThanFromAmount":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									var fromamount="";
									var toamount="";
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												fromamount=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												toamount=$(fn).val();
											}
										});
									}
									var flag=true;
									if((fromamount*1-toamount*1)>0){
										_result = false;
									}
									if(toamount==""){
										_result = true;
									}
								}
								if(_result == false){
									errorMessage.push(labelName2 + "不能小于"+labelName1);
								}
								break;
							//验证开始日期不大于截止日期  add wxsong
							case "FromDateNOtMoreThanToDate":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									var fromdate="";
									var todate="";
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												 fromdate=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												 todate=$(fn).val();
											}
										});
									}
									var flag=compareDate(fromdate,todate);
									if(flag==true){
										_result = false;
									}
								}
								if(_result == false){
									errorMessage.push(labelName1 + "不能大于"+labelName2);
								}
								break;
							case "FromDateNotLessThanEqualToDate":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									var fromdate="";
									var todate="";
									
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												fromdate=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												todate=$(fn).val();
											}
										});
									}
									//fromdate < todate 
									var flag=compareDate2(fromdate,todate);
									
									if(flag==true)
									{
										_result = false;
									}
									if(fromdate == todate){
										_result = false;
									}
									
								}
								if(_result == false){
									errorMessage.push(labelName1 + "不能小于等于"+labelName2);
								}
								break;
							case "FromDateNotLessThanDate":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									var fromdate="";
									var todate="";
									
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												fromdate=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												todate=$(fn).val();
											}
										});
									}
									//fromdate < todate 
									var flag=compareDate2(fromdate,todate);
									if(flag==true){
										_result = false;
									}
								}
								if(_result == false){
									errorMessage.push(labelName1 + "不能小于"+labelName2);
								}
								break;
							case "NotEqual":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[id="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[id="'+ p.colModel[i].hidname +'"]', $(f));
									var dateA="";
									var dateB="";
									
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												 dateA=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												 dateB=$(fn).val();
											}
										});
									}
									
									var flag= (dateA == dateB);
									
									if(flag==true)
									{
										_result = false;
									}
									
								}
								if(_result == false){
									errorMessage.push(labelName1 + "不能和"+labelName2+"相同");
								}
								break;
							//开始、截止日期不跨月
							case "SameYearMonth":
								if(p.colModel[i].fieldName){
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									if(p.colModel[i].labelName1){
										labelName1 = p.colModel[i].labelName1;
									}
									if(p.colModel[i].labelName2){
										labelName2 = p.colModel[i].labelName2;
									}
									var formel = $('input[name="'+ p.colModel[i].fieldName +'"]', $(f));
									var forme2 = $('input[name="'+ p.colModel[i].hidname +'"]', $(f));
									var fromdate="";
									var todate="";
									
									if(formel && formel.length > 0){
										$(formel).each(function (fi, fn) {
											if($(fn).val() != ''){
												 fromdate=$(fn).val();
											}
										});
									}
									if(forme2 && forme2.length > 0){
										$(forme2).each(function (fi, fn) {
											if($(fn).val() != ''){
												 todate=$(fn).val();
											}
										});
									}
									
									_result = (fromdate.substring(0,7) == todate.substring(0,7));
									
								}
								if(_result == false){
									errorMessage.push(labelName1 + "和" + labelName2 + "不能跨月");
								}
								break;
							case "HtmlSelect":															
								//值不能为空校验								
								if(p.colModel[i].notNull && p.colModel[i].notNull == true){
									
									if(_elementValue == '-1'){
										errorFieldName.push(fieldname);
										errorMessage.push(labelName + "值不能为空");
										_result = false;
									}
								}
								break;
							case "NormalProportion":
								_result = $.checkNumericLength(_elementValue, 3, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定3位的整数");
									}
									else{
										errorMessage.push(labelName + "值范围为最小为0，最大为100的整数");
									}
								}else{
									_result = NormalProportionRegExp.test(_elementValue);
									if(_result == false){
										if(fixedLength == true){
											errorMessage.push(labelName + "值固定3位整数");
										}
										else{
											errorMessage.push(labelName + "值范围为最小为0，最大为100的整数");
										}
									}
								}
								break;
							case "NormalProportionInteger1":
								_result = $.checkNumericLength(_elementValue, 3, fixedLength);
								if(_result == false){
									if(fixedLength == true){
										errorMessage.push(labelName + "值固定3位的整数");
									}
									else{
										errorMessage.push(labelName + "值必须为整数");
									}
								}else{
									_result = NormalProportionRegExp.test(_elementValue);
									if(_result == false){
										if(fixedLength == true){
											errorMessage.push(labelName + "值固定3位整数");
										}
										else{
											errorMessage.push(labelName + "值必须为整数");
										}
									}
								}
								break;
							case "NormalProportionInteger":
								_result = $.checkNumericLength1(_elementValue,fixedLength);
								if(_result == true){
								}else{
									errorMessage.push(labelName + "值必须为整数");
								}
								break;
							case "NormalProportionNumber":
								_result = $.checkNumericLength2(_elementValue,50,fixedLength);
								if(_result == true){
								}else{
									errorMessage.push(labelName + "值只能为数字");
								}
								break;
							case "NumberAndEN":
								_result = $.checkNumericAndENLength(_elementValue,fixedLength);
								if(_result == true){
								}else{
									errorMessage.push(labelName + "值只能为数字和字母");
								}
								break;
							case "NotSpecial":
								_result = $.notSpecial(_elementValue,fixedLength);
								if(_result == true){
								}else{
									errorMessage.push(labelName + "值不能包含特殊字符");
								}
								break;
							case "NotquanSpecial":
								_result = $.notquanSpecial(_elementValue,fixedLength);
								if(_result == true){
								}else{
									errorMessage.push(labelName + "(值不能包含特殊字符)");
								}
								break;
						}
						
						if(_result == false){
							errorFieldName.push(fieldname);
						}
					}
				}
			}
			
			var errors = "";
			if(errorMessage && errorMessage.length > 0){
				if(errorMessage.length == 1) {
					errors = errorMessage[0] + "     ";
				}else{
					for(var i=0; i<errorMessage.length; i++){
						errors = errors + + (i+1) + "、" + errorMessage[i] + "     \r\n";
					}
				}
				$.messager.alert('信息提示',errors);
//				alert(errors);
				formReturn = false;
			}
			
			if(errorFieldName && errorFieldName.length > 0){
				var _elements = $('input[name="'+ errorFieldName[0] +'"],textarea[name="'+ errorFieldName[0] +'"]', $(f));
				//暂时只处理form元素name为一个的情况
				if(_elements && _elements.length == 1){
					$(_elements[0]).focus();
				}
			}
		}
		return formReturn;
	},

	$.fn.regularExpressionFormValidate = function (p) {
		var f = this;
		return $.addRegularExpressionFormValidate(f, p);
	}; 
	//start specialCharacterFormValidate
	$.addSpecialCharacterFormValidate = function(f) {
		var bool = true;
		scExpression_text = /select|update|delete|exec|count|like|'|>|<|%|--/i;
		$('textarea', $(f)).each(function(i, e) {
			//对textarea去掉换行处理
			$(e).val($(e).val().replace(/[\r\n]/g, ''));
		});
		$('input[type=password],input[type=text]', $(f)).each(function(i, e) {
			if(scExpression_text.test($(e).val())){ 
				$.messager.alert('信息提示','表单提交的数据输入了特殊字符和SQL关键字请检查是否含有select、update、delete、exec、count、like【不区分大小写】、大于号、小于号、百分号、单引号【英文字符】');
//				alert('表单提交的数据输入了特殊字符和SQL关键字请检查是否含有select、update、delete、exec、count、like【不区分大小写】、大于号、小于号、百分号、单引号【英文字符】');
				bool = false;
				return bool;
	    	}
		});
		return bool;
	},
	$.fn.specialCharacterFormValidate = function() {
		var f = this;
		return $.addSpecialCharacterFormValidate(f);
	}; 
})(jQuery);