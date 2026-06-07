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

    const profiles = [];

    names.forEach(name => {
       profiles.push(new CreateProfile(name.textContent.trim()));
    });

    console.log(profiles);
}

class CreateProfile {
    constructor(name) {
        this.name = name;
        this.imgLink = "https://www.sfu.ca/content/sfu/fas/computing/people/faculty/faculty-members/"+nameLinkified(name)+".img.png"
        this.rating = 0;
    }
}

loadData();

