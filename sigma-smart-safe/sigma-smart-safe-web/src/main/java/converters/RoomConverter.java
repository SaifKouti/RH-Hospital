package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bean.UserBean;
import persistence.Room;

@FacesConverter("rc")
public class RoomConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		UserBean userBean = context.getApplication().evaluateExpressionGet(context, "#{userBean}", UserBean.class);
		Room room = userBean.dofindRoomByCode(value);
		return room;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return null;
	}
}
