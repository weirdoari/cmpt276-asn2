package com.cmpt276_cs_prof_rate.demo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.cmpt276_cs_prof_rate.demo.models.Users;

@Service
public class FetchUsers {

    public List<Users> loadData() {
        String url = "https://www.sfu.ca/fas/computing/people/faculty.html";
        List<Users> profiles = new ArrayList<>();

        Map<String, String> unusualLinks = new HashMap<>();
        unusualLinks.put("matthew-amy", "matt-amy");
        unusualLinks.put("victor-cheung", "victor_cheung");
        unusualLinks.put("uwe-glaesser", "uwe-glasser");
        unusualLinks.put("harinder-singh-khangura", "khangura");
        unusualLinks.put("ke-li", "keli");
        unusualLinks.put("maxwell-libbrecht", "maxwl");
        unusualLinks.put("hang-ma", "hangma");
        unusualLinks.put("ali-mahdavi-amiri-", "amahdavi");
        unusualLinks.put("zhengjie-miao", "zhengjie_miao"); 
        unusualLinks.put("jiangchuan-liu", "jcl-iu"); 
        unusualLinks.put("gregory-baker", "greg-baker"); 
        unusualLinks.put("john-edgar", "edgar-john"); 
        unusualLinks.put("anders-miltner", "miltner");
        unusualLinks.put("steven-pearce", "stevenp");
        unusualLinks.put("xue-bin-jason-peng", "xbpeng");
        unusualLinks.put("frederick-popowich", "popowich");
        unusualLinks.put("anoop-sarkar", "anoop");
        unusualLinks.put("manolis-savva", "msavva");
        unusualLinks.put("oliver-schulte", "oschulte");
        unusualLinks.put("igor-shinkar", "ishinkar");
        unusualLinks.put("arrvindh-shriraman", "ashriram");
        unusualLinks.put("william-sumner", "wsumner");
        unusualLinks.put("andrea-tagliasacchi", "taiya");
        unusualLinks.put("mohammad-tayebi", "mohammad_tayebi");
        unusualLinks.put("evgenia-ternovska", "ter");
        unusualLinks.put("sharan-vaswani", "sharan_vaswani");
        unusualLinks.put("nicholas-vincent", "nicholas_vincent");
        unusualLinks.put("keval-vora", "keval");
        unusualLinks.put("ke-wang", "wangk");
        unusualLinks.put("tao-wang", "taowang");
        unusualLinks.put("tianzheng-wang", "tzwang");
        unusualLinks.put("yuepeng-wang", "yuepeng");
        unusualLinks.put("kay-c-wiese", "wiese");
        unusualLinks.put("jianliang-wu", "wujl");
        unusualLinks.put("cynthia-xie", "cxie");
        unusualLinks.put("xingdong-yang", "xingdong_yang");
        unusualLinks.put("kangkang-yin", "kkyin");
        unusualLinks.put("richard-zhang", "haoz");
        unusualLinks.put("siqi-zhou", "siqizhou");
        unusualLinks.put("zhenman-fang", "adjunct-professors/fang--zhenman");
        unusualLinks.put("tenzin-doleck", "adjunct-professors/doleck--tenzin");
        unusualLinks.put("saeid-asgari", "adjunct-professors/saeid");
        unusualLinks.put("daniel-cohen-or", "adjunct-professors/daniel-cohen-or");
        unusualLinks.put("graham-finlayson", "adjunct-professors/graham-finlayson");
        unusualLinks.put("shervin-shirmohammadi", "adjunct-professors/shervin-shirmohammadi");
        unusualLinks.put("gregory-mori", "adjunct-professors/mori");
        unusualLinks.put("kwang-moo-yi", "adjunct-professors/kwang-moo-yi");
        unusualLinks.put("pulei-xiong", "adjunct-professors/pulei-xiong");
        unusualLinks.put("jiannan-wang", "adjunct-professors/jnwang");
        unusualLinks.put("peter-chun", "adjunct-professors/peter-chun");
        unusualLinks.put("stella-atkins", "emeriti-faculty-members/stella");
        unusualLinks.put("binay-bhattacharya", "emeriti-faculty-members/binay");
        unusualLinks.put("warren-burton", "emeriti-faculty-members/burton");
        unusualLinks.put("veronica-dahl", "emeriti-faculty-members/veronica");
        unusualLinks.put("james-delgrande", "emeriti-faculty-members/jim");
        unusualLinks.put("mark-drew", "emeriti-faculty-members/mark");
        unusualLinks.put("brian-funt", "emeriti-faculty-members/funt");
        unusualLinks.put("bob-hadley", "emeriti-faculty-members/hadley");
        unusualLinks.put("bill-havens", "emeriti-faculty-members/havens");
        unusualLinks.put("pavol-hell", "emeriti-faculty-members/pavol");
        unusualLinks.put("david-mitchell", "emeriti-faculty-members/mitchell");
        unusualLinks.put("jian-pei", "emeriti-faculty-members/jian-pei");
        unusualLinks.put("thomas-c-shermer", "emeriti-faculty-members/thomas-c--shermer");
        unusualLinks.put("tiko-kameda", "emeriti-faculty-members/tiko");
        unusualLinks.put("ramesh-krishnamurti", "emeriti-faculty-members/ramesh");
        unusualLinks.put("anne-lavergne", "emeriti-faculty-members/alavergn");
        unusualLinks.put("ze-nian-li", "emeriti-faculty-members/li");
        unusualLinks.put("art-liestman", "emeriti-faculty-members/art");
        unusualLinks.put("wo-shun-luk", "emeriti-faculty-members/woshun");
        unusualLinks.put("joseph-peters", "emeriti-faculty-members/peters");
        unusualLinks.put("janice-regan", "emeriti-faculty-members/jregan");
        unusualLinks.put("james-j-weinkam", "emeriti-faculty-members/jjw");
        unusualLinks.put("tom-calvert", "in-memoriam/tom");
        unusualLinks.put("anthony-hunter-dixon", "in-memoriam/tony-dixon");
        unusualLinks.put("ryan-shea", "in-memoriam/ryan-shea");

        //adjunct-professors/kwang-moo-yi
        
        try {
            Document doc = Jsoup.connect(url).get(); 
            // Previous JS Fetch logic I used I found it to be only possible witth Jsoup.

            Elements names = doc.select(".faculty-name");
            Elements positions = doc.select(".position");
            Elements mails = doc.select(".faculty-profile-icon.email");
            
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i).text().trim();

                String position = "";
                if (i < positions.size()) {
                    position = positions.get(i).text().trim();
                    if (position.contains("|")) {
                        position = position.split("\\|")[0].trim();
                    }
                }

                String mail = "";
                if (i < mails.size()) {
                    mail = mails.get(i).attr("href").replace("mailto:", "").trim();
                }

                String nameLinkified = nameLinkified(name);
                System.err.println("Processing: " + name + " -> " + nameLinkified);
                String imgLink = "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/faculty-members/" + nameLinkified + ".img.png";
                if (unusualLinks.containsKey(nameLinkified)) {
                    if (unusualLinks.get(nameLinkified).contains("/")) {
                        imgLink = "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/" + unusualLinks.get(nameLinkified) + ".img.png";
                    } else {
                        imgLink = "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/faculty-members/" + unusualLinks.get(nameLinkified) + ".img.png";
                    }
                }

                profiles.add(new Users(
                        name,
                        imgLink,
                        position,
                        mail
                ));
            }
        } catch (IOException e) {
            System.out.println("Failed to load faculty data: " + e.getMessage());
        }

        return profiles;
    }

    private String nameLinkified(String name) {
        name = name.replace(" ", "-");
        name = name.replace(".", "");
        name = name.replace("'", "");

        String[] nameParts = name.split(",");

        String nameInFor = "";

        for (int index = 1; index < nameParts.length; index++) {
            nameInFor = nameParts[index] + "-" + nameInFor;
        }

        nameInFor += nameParts[0];

        if (nameInFor.length() > 0) {
            nameInFor = nameInFor.substring(1);
        }

        return nameInFor.toLowerCase();
    }

}