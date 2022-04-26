package com.example.registrationapp.model

class YourInfo {
    var education:String = ""
    var year_of_passing:Int
    var grade:String = ""
    var experience:Int
    var designation:String = ""
    var domain:String= ""

    constructor(
        education: String,
        year_of_passing: Int,
        grade: String,
        experience: Int,
        designation: String,
        domain: String
    ) {
        this.education = education
        this.year_of_passing = year_of_passing
        this.grade = grade
        this.experience = experience
        this.designation = designation
        this.domain = domain
    }
}
