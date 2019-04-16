package it.maucel89.liferay.elastic.client.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import it.maucel89.liferay.elastic.client.web.ElasticClientPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ElasticClientPortletKeys.ELASTIC_CLIENT,
		"mvc.command.name=" + ExecuteMVCRenderCommand.NAME
	},
	service = MVCRenderCommand.class
)
public class ExecuteMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Http.Options options = new Http.Options();

		String elasticBaseURL = ParamUtil.getString(
			renderRequest, "elasticBaseURL");

		String command = ParamUtil.getString(
			renderRequest, "command");

		String results = StringPool.BLANK;
		String location = elasticBaseURL + command;

		if (Validator.isNotNull(location)) {

			options.setLocation(elasticBaseURL + command);

			try {
				results = _escape(HttpUtil.URLtoString(options));
			}
			catch (IOException e) {
				_log.error(e, e);
			}
		}

		renderRequest.setAttribute("results", results);

		return "/view.jsp";
	}

	private String _escape(String result) {
		return result.replace(StringPool.NEW_LINE, "<br>");
	}

	public static final String NAME = "/execute";

	private static final Log _log = LogFactoryUtil.getLog(
		ExecuteMVCRenderCommand.class);

}
