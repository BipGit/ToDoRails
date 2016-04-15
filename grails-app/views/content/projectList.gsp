<%--
  Created by IntelliJ IDEA.
  User: VIKTOR
  Date: 13.04.2016
  Time: 17:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="gear">
    <title></title>
    <g:javascript library="jquery" plugin="jquery"/>
    <g:javascript>
        $(document).ready(function(){
            $('.chbxItSelf').change(function(e){
                if($(this).is(':checked')){
                    console.log(e)
                }
                else {
                    console.log('checkbox unchecked')
                }
            });

            $('td').click(function(e){
                var tr = $(this).parent()
                console.log(tr.attr('taskNumber'))
            });

        });

        function typeAlert(){

        }
    </g:javascript>

    <style>

    #projectContainer{
        width: 60%;
        height: 100%;
    }
    .projectHead {
        font-family: "Trebuchet MS", Verdana, Geneva, Arial, Helvetica, sans-serif;
        line-height: inherit;
    }
    .tableHeadDiv {
        height: 50px;
        vertical-align: middle;
        margin-bottom: 0;
        background-color: #006dba;
    }

    .taskName {
        height: auto;
        width: 70%;
        vertical-align: middle;
        border-left: solid 1px;
        border-left-color: #999999;
    }

    .projectTable {
        background-color: #E9E9E9;
        border-bottom-left-radius: 15px;
        border-bottom-right-radius: 15px;
    }

    .checkbox {
        margin: 0 auto;
        width: 50%;
    }

    .taskLevelUp, .taskLevelDown{
        width: 20px;
        height: 20px;
    }
    </style>
</head>

<body>
    <g:each in="${projects}" var="project">
        ${project}
    </g:each>

    <div class="container-fluid" id="contentContainer">
        <div class="container" id="projectContainer">
            <pList:projectTagLib>Hello</pList:projectTagLib>
        </div>
    </div>
</body>
</html>