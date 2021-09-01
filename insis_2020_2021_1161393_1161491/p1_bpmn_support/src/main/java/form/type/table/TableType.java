package form.type.table;

import java.util.List;

import org.activiti.engine.form.AbstractFormType;
import org.activiti.engine.impl.util.json.JSONArray;

public class TableType extends AbstractFormType {
	private static final long serialVersionUID = 5352747903871169593L;

	public static final String TYPE_NAME = "table";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		// When there's no model value, return an empty array
		if (modelValue == null) {
			return new JSONArray().toString();
		}
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) modelValue;
		JSONArray array = new JSONArray();
		for (String string : list) {
			array.put(string);
		}

		return array.toString();
	}

}
