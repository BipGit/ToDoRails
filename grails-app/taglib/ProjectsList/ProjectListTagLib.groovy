package ProjectsList

import Project.Project

class ProjectListTagLib {
//    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "pList"

    def projectTagLib = { attrs, body ->
        out << body() << createList()
    }

    private String createList() {
        def projects = Project.findAll()
        StringBuilder sb = new StringBuilder()

        String imageArrowUp = resource(dir: "images", file: "ic_arrow_drop_up_black_18dp_2x.png")
        String imageArrowDown = resource(dir: "images", file: "ic_arrow_drop_down_black_18dp_2x.png")

        projects.each {
            sb << "<table class=\"table projectTable\" cellpadding=\"5\">"
            sb << "<thead>"
            sb << "<div class=\"tableHeadDiv\">"
            sb << "<h2 class=\"projectHead\">#${it.id} >>>>>> ${it.projectName}</h2>"
            sb << "</div>"
            sb << "</thead>"
            sb << "<tbody>"
            it.tasks.each {
                sb << "<tr class=\"taskRow\" taskNumber=\"${it.id}\">"
                sb << "<td class=\"chkbxCell\" >"
                sb << "<div class=\"checkbox\">"
                sb << "<label>"
                sb << "<input class=\"chbxItSelf\" type=\"checkbox\" value=\"\">"
                sb << "</label>"
                sb << "</div>"
                sb << "</td>"
                sb << "<td class=\"taskName\">"
                sb << "${it.subject}"
                sb << "</td>"
                sb << "<td>"
                sb << "<a href=\""+g.createLink(controller: "content", action:"increaseTaskPriority", params:[taskID: it.id, projectID:it.project.id])+"\">"
                sb << "<img class=\"taskLevelUp\" src=\"${imageArrowUp}\">"
                sb << "</a>"
                sb << "<a href=\""+g.createLink(controller: "content", action:"decreaseTaskPriority", params:[taskID: it.id, projectID:it.project.id])+"\">"
                sb << "<img class=\"taskLevelDown\" src=\"${imageArrowDown}\">"
                sb << "</a>"
                sb << "</td>"
                sb << "</tr>"
            }
            sb << "</tbody>"
            sb << "</table>"
        }
        return sb as String
    }
}