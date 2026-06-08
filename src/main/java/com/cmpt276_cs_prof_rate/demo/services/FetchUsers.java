package com.cmpt276_cs_prof_rate.demo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

                //System.out.println("Fetched user: " + name + ", " + position + ", " + mail + " image link: " + "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/faculty-members/" + nameLinkified(name) + ".img.png");
                String imgLink = "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/faculty-members/" + nameLinkified(name) + ".img.png";

                profiles.add(new Users(
                        String.valueOf(i + 1),
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