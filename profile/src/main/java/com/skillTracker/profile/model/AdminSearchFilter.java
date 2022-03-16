package com.skillTracker.profile.model;

public class AdminSearchFilter {
    private String name;
    private String skillCategory;
    private String skill;

    public AdminSearchFilter() {
    }

    public AdminSearchFilter(String name, String skillCategory, String skill) {
        this.name = name;
        this.skillCategory = skillCategory;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkillCategory() {
        return skillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
