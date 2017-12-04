package com.spring.constant;

import lombok.Builder;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// @formatter:off
@Log
public class CodeGenerator {

    public static void main(String[] args) {
        File generateFile = new CodeGenerator().generate();
        if (generateFile == null) {
            return;
        }
    }


    public File generate() {
        log.warning("start gen");

        List<Code> codes = loadCodes();
        if (CollectionUtils.isEmpty(codes)) {
            return null;
        }

        File file = new File(System.getenv("user.home"), "CodeConstants.java");
        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            out.printf("package %s;\n\n\n", this.getClass().getPackage().getName());
            out.printf("public class CodeConstants {\n\n");
            String codeGroup = null;
            for (Code c : codes) {
                if (!StringUtils.equals(c.codeGroup, codeGroup)) {
                    codeGroup = c.codeGroup;
                    out.printf("\tpublic static final String %s = \"%s\";\n", c.codeGroup, c.groupDesc);
                }
                out.printf("\tpublic static final String %s_%s = \"%s\"; // %s - %s\n", c.code,
                        c.codeNm.replaceAll("[ ,?&\\(\\)\\.\\/·\\:\\+]", "_").toUpperCase(), c.code, c.codeNm, c.codeDesc);
            }
            out.printf("}\n");

            log.warning("finish gen: " + file.getAbsolutePath());

            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @SneakyThrows
    private List<Code> loadCodes() {
        StringBuilder listCodeSQL = new StringBuilder()
                .append("SELECT code, code_group, code_nm, code_desc, group_desc FROM T_CODE ORDER BY code ASC\n");

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(listCodeSQL.toString())) {
            List<Code> codeList = new ArrayList<>();

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                codeList.add(Code.builder()
                        .code(rs.getString("code"))
                        .codeGroup(rs.getString("code_group"))
                        .codeNm(rs.getString("code_nm"))
                        .codeDesc(rs.getString("code_desc"))
                        .groupDesc(rs.getString("group_desc"))
                        .build());
            }
            return codeList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    @SneakyThrows
    private Connection getConnection() {
        Class.forName("com.mysql.jdbc.Driver");
        //jdbc:mysql://craw2:3310/Vcommerce
        return DriverManager.getConnection("jdbc:mysql://craw2:3310/Vcommerce", "vcom_svc", "vF8c#WNx");
    }


    @Builder
    static class Code {

        String code;
        String codeGroup;
        String codeNm;
        String codeDesc;
        String groupDesc;
    }
}