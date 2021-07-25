function addHeroSelect(){  
        
        var heroes=["Abaddon","Alchemist","Ancient Apparition","Anti-Mage","Arc Warden","Axe","Bane","Batrider","Beastmaster","Bloodseeker","Bounty Hunter","Brewmaster","Bristleback","Broodmother","Centaur Warrunner","Chaos Knight","Chen","Clinkz","Clockwerk","Crystal Maiden","Dark Seer","Dark Willow","Dawnbreaker","Dazzle","Death Prophet","Disruptor","Doom","Dragon Knight","Drow Ranger","Earth Spirit","Earthshaker","Elder Titan","Ember Spirit","Enchantress","Enigma","Faceless Void","Grimstroke","Gyrocopter","Hoodwink","Huskar","Invoker","Io","Jakiro","Juggernaut","Keeper of the Light","Kunkka","Legion Commander","Leshrac","Lich","Lifestealer","Lina","Lion","Lone Druid","Luna","Lycan","Magnus","Mars","Medusa","Meepo","Mirana","Monkey King","Morphling","Naga Siren","Nature`s Prophet","Necrophos","Night Stalker","Nyx Assassin","Ogre Magi","Omniknight","Oracle","Outworld Destroyer","Pangolier","Phantom Assassin","Phantom Lancer","Phoenix","Puck","Pudge","Pugna","Queen of Pain","Razor","Riki","Rubick","Sand King","Shadow Demon","Shadow Fiend","Shadow Shaman","Silencer","Skywrath Mage","Slardar","Slark","Snapfire","Sniper","Spectre","Spirit Breaker","Storm Spirit","Sven","Techies","Templar Assassin","Terrorblade","Tidehunter","Timbersaw","Tinker","Tiny","Treant Protector","Troll Warlord","Tusk","Underlord","Undying","Ursa","Vengeful Spirit","Venomancer","Viper","Visage","Void Spirit","Warlock","Weaver","Windranger","Winter Wyvern","Witch Doctor","Wraith King","Zeus"];
    
 
        
        
        var selectEnemy1=document.getElementById("selectEnemy1");
        var selectEnemy2=document.getElementById("selectEnemy2");
        var selectEnemy3=document.getElementById("selectEnemy3");
        var selectEnemy4=document.getElementById("selectEnemy4");
        var selectEnemy5=document.getElementById("selectEnemy5");
        var selectAlly1=document.getElementById("selectAlly1");
        var selectAlly2=document.getElementById("selectAlly2");
        var selectAlly3=document.getElementById("selectAlly3");
        var selectAlly4=document.getElementById("selectAlly4");
        
        for (var i=0;i<heroes.length;i++)
            {
                var hero=heroes[i];
                var el1=document.createElement("option");
                el1.text=hero;
                el1.value=i+1;
                var el2=document.createElement("option");
                el2.text=hero;
                el2.value=i+1;
                var el3=document.createElement("option");
                el3.text=hero;
                el3.value=i+1;
                var el4=document.createElement("option");
                el4.text=hero;
                el4.value=i+1;
                var el5=document.createElement("option");
                el5.text=hero;
                el5.value=i+1;
                var el6=document.createElement("option");
                el6.text=hero;
                el6.value=i+1;
                var el7=document.createElement("option");
                el7.text=hero;
                el7.value=i+1;
                var el8=document.createElement("option");
                el8.text=hero;
                el8.value=i+1;
                var el9=document.createElement("option");
                el9.text=hero;
                el9.value=i+1;
                selectEnemy1.append(el1);
                selectEnemy2.append(el2);
                selectEnemy3.append(el3);
                selectEnemy4.append(el4);
                selectEnemy5.append(el5);
                selectAlly1.append(el6);
                selectAlly2.append(el7);
                selectAlly3.append(el8);
                selectAlly4.append(el9);
               
            }
      }     
