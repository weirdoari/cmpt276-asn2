function nameLinkified(name) {
    name = name.replaceAll(" ","-");
    let nameparts = name.split(",");
    let nameInFor = "";
    for (let index = 1; index < nameparts.length; index++) {
        nameInFor = nameparts[index]+"-"+nameInFor;
    }
    nameInFor += nameparts[0];
    nameInFor = nameInFor.slice(1,nameInFor.length);
    return nameInFor.toLowerCase();
} 

async function loadData() {
    const response = await fetch("https://www.sfu.ca/fas/computing/people/faculty.html");
    const html = await response.text();

    const parser = new DOMParser();
    const doc = parser.parseFromString(html, "text/html");

    const names = doc.querySelectorAll(".faculty-name");
    const position = doc.querySelectorAll(".position");
    const mail = doc.querySelectorAll(".faculty-profile-icon.email");

    const profiles = [];

    names.forEach((name, index) => {
        profiles.push(
            new CreateProfile(
                name.textContent.trim(),
                position[index].textContent.trim(),
                mail[index].textContent.trim()
            )
        );
    });

    console.log(html);
    console.log(profiles);
}

class CreateProfile {
    constructor(name,position,mail) {
        this.id = 0;
        this.name = name;
        this.imgLink = "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/faculty-members/"+nameLinkified(name)+".img.png"
        this.roleType = position;
        this.mail = mail;
        this.clarity = 0;
        this.niceness = 0;
        this.knowledgeableScore = 0;
        //this.createdAt = timestamp
    }
}

loadData();

