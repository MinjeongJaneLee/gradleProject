package com.spring.utility.filter;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;
import org.owasp.esapi.ESAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class XssRequestWrapper extends HttpServletRequestWrapper {

    // @formatter:off
    private static Whitelist whitelist = Whitelist.basicWithImages()
            .removeProtocols("img", "src", "http", "https")
            .addAttributes("p", "style")
            .addAttributes("div", "style")
            .addAttributes("span", "style")
            .addAttributes("table", "style", "width", "height", "class", "border", "cellpadding", "cellspacing", "_se2_tbl_template")
            .addAttributes("tr", "style", "width", "height", "class")
            .addAttributes("td", "style", "width", "height", "class", "colspan", "rowspan")
            .addAttributes("a", "target")
            .addAttributes("iframe", "width", "height", "src", "frameborder", "allowfullscreen", "scrolling"); //youtube 동영상
    private static OutputSettings outputSettings = new OutputSettings()
            .prettyPrint(false);
    // @formatter:on


    public XssRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }


    public static String cleanNoMarkup(String input) {
        return Jsoup.clean(input, "", whitelist, outputSettings);
    }


    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);

        if (values == null) {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripXSS(values[i]);
        }

        return encodedValues;
    }


    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);

        return stripXSS(value);
    }


    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripXSS(value);
    }


    private String stripXSS(String value) {
        if (value == null) {
            return null;
        }

        String result = ESAPI.encoder().canonicalize(value);
        if (StringUtils.isBlank(result)) {
            return StringUtils.EMPTY;
        }
        result = result.replaceAll("\0", "");
        result = cleanNoMarkup(result);

        return result;
    }
}
