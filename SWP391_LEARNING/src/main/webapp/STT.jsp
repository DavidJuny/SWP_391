<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/30/2023
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
       <head>
              <title>Speech to text</title>
       </head>
       <body>
              <div class="speaker" style="display: flex;justify-content: space-between;width: 13rem;box-shadow: 0 0 13px #0000003d;border-radius: 5px;">
                     <p id="action" style="color: grey;font-weight: 800; padding: 0; padding-left: 2rem;"></p>
                     <button onclick="runSpeechRecog()" style="border: transparent;padding: 0 0.5rem;">
                            Speech
                     </button>
              </div>
              <h3 id="output"  class="hide"></h3>
              <form id="speechForm" action="STTController" method="post">
                     <input id="transcriptInput" type="hidden" name="transcript">
              </form>

              <c:if test="${result !=null}">
                     <h4>
                            Text you just said : ${text}
                     </h4>

                     <h4>
                            Answer :
                            <c:forEach var="answer" items="${result}">
                                   ${answer}
                            </c:forEach>
                     </h4>
                     <h4>
                            SpeechPoint :
                            ${speechPoint}
                     </h4>
              </c:if>

              <script>
                     runSpeechRecog = () => {
                            document.getElementById("output").innerHTML = "Loading text...";
                            var output = document.getElementById('output');
                            var action = document.getElementById('action');
                            let recognization = new webkitSpeechRecognition();
                            recognization.onstart = () => {
                                   action.innerHTML = "Listening...";
                            }
                            recognization.onresult = (e) => {
                                   var transcript = e.results[0][0].transcript;
                                   output.innerHTML = transcript;
                                   output.classList.remove("hide")
                                   action.innerHTML = "";
                                   document.getElementById('transcriptInput').value = transcript;
                                   document.getElementById('speechForm').submit();
                            }
                            recognization.start();
                     }
              </script>
       </body>
</html>
