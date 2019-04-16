<%@ include file="/init.jsp" %>

<%
String command = ParamUtil.getString(request, "command");
String results = (String) renderRequest.getAttribute("results");
%>

<liferay-portlet:renderURL varImpl="executeURL">
	<portlet:param name="mvcRenderCommandName" value="<%= ExecuteMVCRenderCommand.NAME %>" />
</liferay-portlet:renderURL>

<aui:form action="<%= executeURL %>" method="post" name="fm">
    <aui:fieldset>

		<div class="elastic-client-form">
			<span class="aui-execute-bar">

				<aui:input
					type="hidden"
					name="elasticBaseURL"
					value="<%= elasticBaseURL %>"
				/>

				<aui:input
					label="<%= elasticBaseURL %>"
					type="text"
					name="command"
				/>

				<span class="input-group-btn">
					<button
						value=""
						class="btn btn-primary"
						onClick="<%= renderResponse.getNamespace() + "search();" %>"
					>
						<i class="icon-play"></i>
					</button>
				</span>

			</span>
		</div>
	</aui:fieldset>
</aui:form>

<c:if test="<%= Validator.isNotNull(results) %>">
	<pre><code><%= results %></code></pre>
</c:if>
