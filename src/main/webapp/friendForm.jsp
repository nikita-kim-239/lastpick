<%-- 
    Document   : friendForm
    Created on : 19.07.2021, 18:12:32
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friendship Form</title>
        <style>
        body{
            margin:20px;
        }
        
        </style>
        <script language="javascript">
        
        
         

        
      function addHeroSelect(){  
        
        var heroes=["Abaddon","Alchemist","Ancient Apparition","Anti-Mage","Arc Warden","Axe","Bane","Batrider","Beastmaster","Bloodseeker","Bounty Hunter","Brewmaster","Bristleback","Broodmother","Centaur Warrunner","Chaos Knight","Chen","Clinkz","Clockwerk","Crystal Maiden","Dark Seer","Dark Willow","Dawnbreaker","Dazzle","Death Prophet","Disruptor","Doom","Dragon Knight","Drow Ranger","Earth Spirit","Earthshaker","Elder Titan","Ember Spirit","Enchantress","Enigma","Faceless Void","Grimstroke","Gyrocopter","Hoodwink","Huskar","Invoker","Io","Jakiro","Juggernaut","Keeper of the Light","Kunkka","Legion Commander","Leshrac","Lich","Lifestealer","Lina","Lion","Lone Druid","Luna","Lycan","Magnus","Mars","Medusa","Meepo","Mirana","Monkey King","Morphling","Naga Siren","Nature`s Prophet","Necrophos","Night Stalker","Nyx Assassin","Ogre Magi","Omniknight","Oracle","Outworld Destroyer","Pangolier","Phantom Assassin","Phantom Lancer","Phoenix","Puck","Pudge","Pugna","Queen of Pain","Razor","Riki","Rubick","Sand King","Shadow Demon","Shadow Fiend","Shadow Shaman","Silencer","Skywrath Mage","Slardar","Slark","Snapfire","Sniper","Spectre","Spirit Breaker","Storm Spirit","Sven","Techies","Templar Assassin","Terrorblade","Tidehunter","Timbersaw","Tinker","Tiny","Treant Protector","Troll Warlord","Tusk","Underlord","Undying","Ursa","Vengeful Spirit","Venomancer","Viper","Visage","Void Spirit","Warlock","Weaver","Windranger","Winter Wyvern","Witch Doctor","Wraith King","Zeus"];
        
        
        var selectHero1=document.getElementById("selectHero1");
        var selectHero2=document.getElementById("selectHero2");
        
        for (var i=0;i<heroes.length;i++)
            {
                var hero=heroes[i];
                var el1=document.createElement("option");
                el1.text=hero;
                el1.value=i+1;
                var el2=document.createElement("option");
                el2.text=hero;
                el2.value=i+1;
 
                selectHero1.append(el1);
                selectHero2.append(el2);
                              
            }
      }      
      
     
    </script>  
        
    </head>
    <body onload="addHeroSelect()">
        
        <form action="friendship" method="post">
            <p>Hero1</p>
            
            <select id="selectHero1" name="hero1">
                <option disabled>Выберите героя</option>
            </select>
            
            <br/>
            <p>Hero2</p>
            
            <select id="selectHero2" name="hero2">
                <option disabled>Выберите героя</option>
            </select>
            
            <br/>

            <input type="submit"  value="Create"/>
        </form>
        
    </body>
</html>
