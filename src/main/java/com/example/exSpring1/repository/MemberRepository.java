package com.example.exSpring1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exSpring1.model.Member;

@Repository
public class MemberRepository {
    

    private static final String NAME_SEARCH_QUERY = """
            
    SELECT 
        name
    FROM 
        members
    WHERE 
        name 
    LIKE 
        :name;
            """;

            private static final String QUERY = """
            
            SELECT 
                name
            FROM 
                members;

                    """;

    private static final RowMapper<Member> M_ROW_MAPPER = (rs, rowNum)->{

        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setName(rs.getString("name"));
        member.setAge(rs.getString("age"));
        member.setDepId(rs.getInt("dep_id"));

        return member;
    };


    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Member> findMember(){
    List<Member> memberList = new ArrayList<>();
    memberList = template.query(NAME_SEARCH_QUERY, M_ROW_MAPPER);
    return memberList;
    }

    public List<Member> findName(String name) {

        String sql = "SELECT id, name, age, dep_id  FROM members WHERE name LIKE :name";
        String escapedName = "%" + name + "%";
    
        // SqlParameterSourceオブジェクトを使って値を設定
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("name", escapedName);
    
        List<Member> memberList = template.query(sql, parameterSource, M_ROW_MAPPER);
        return memberList;
    
    }
    
}
