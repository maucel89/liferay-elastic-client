package it.maucel89.liferay.elastic.client.web;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author maucel89
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=elastic-client-portlet",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.display-name=Elastic Client",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ElasticClientPortletKeys.ELASTIC_CLIENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class ElasticClientPortlet extends MVCPortlet {
}