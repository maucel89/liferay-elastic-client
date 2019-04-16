<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form
	action="<%= configurationActionURL %>"
	method="post"
	name="fm"
>

	<div class="portlet-configuration-body-content">

		<div class="container-fluid-1280">

		 	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

			<aui:fieldset-group markupView="lexicon">

				<aui:fieldset collapsible="<%= false %>" label="settings">

					<aui:input name="preferences--elasticBaseURL--" type="text" value="<%= elasticBaseURL %>" />

				</aui:fieldset>

			</aui:fieldset-group>
		</div>
	</div>

	<aui:button-row>
		<aui:button type="submit" cssClass="btn-lg"></aui:button>
		<aui:button type="cancel" cssClass="btn-lg"></aui:button>
	</aui:button-row>

</aui:form>

