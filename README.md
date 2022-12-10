<head>
	<link rel="icon" href="https://lh3.googleusercontent.com/asPozAuGQpJqNz-PB0yesBw9wRGkLDuquGqCf0p47rqBSvhxU5pdNHS27O5fuSF_RyY=s180-rw">
</head>
<table style="border-collapse:collapse;border-spacing:0" class="tg">
	<tr>
		<th style="font-family:Arial, sans-serif;font-size:20px;font-weight:bold;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#228B22;background-color:#ffffff;color:#ffffff;text-align:center;vertical-align:top">
			<a href="#mi1">
				<font color="#228B22">MedienInformatik</font>
			</a>
		</th>
		<th style="font-family:Arial, sans-serif;font-size:20px;font-weight:bold;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#228B22;background-color:#ffffff;color:#ffffff;text-align:center;vertical-align:top">
			<a href="#pi">
				<font color="#228B22">Praktische Informatik</font>
			</a>
		</th>
		<th style="font-family:Arial, sans-serif;font-size:20px;font-weight:bold;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#228B22;background-color:#ffffff;color:#ffffff;text-align:center;vertical-align:top">
			<a href="#free">
				<font color="#228B22">Freetime &amp; more</font>
			</a>
		</th>
		<th style="font-family:Arial, sans-serif;font-size:20px;font-weight:bold;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#228B22;background-color:#ffffff;color:#ffffff;text-align:center;vertical-align:top">
			<a href="#me">
				<font color="#228B22">More from Me</font>
			</a>
		</th>
		<th style="font-family:Arial, sans-serif;font-size:20px;font-weight:bold;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#228B22;background-color:#ffffff;color:#ffffff;text-align:center;vertical-align:top">
			<a href="#contact">
				<font color="#228B22">Contact</font>
			</a>
		</th>
	</tr>
</table>

<h1 id ="top">Welcome to my Website!</h1>

If you need help with your courses and exams, or are just looking for some fun things for your free time, you have come to the right place! For more cool stuff, check out my other <a href="https://leolion.tk">website!</a>

**Did you know?** I offer Java and Python software development. For price enquires, see the <a href="#contact">contact</a> section.

# What can you find here?

If you study computer science or something similar you might find some helpful examples and sample solutions to various fields of study. These have accumulated over the years during my studies at the University of Bremen, and shall be published here to help you advance in your studies.

Furthermore, you will find various guides for a wide range of things, as well as some cool scripts for other tasks.

# Who am I?

My name is Leonard Haddad.<br/> I am a 22 year old, Israeli-German Computer-Science Masters student at the University of Bremen.<br/> On this Website you can find some stuff I created to help others out with their courses, along with some other cool stuff I do in my free-time.<br/>If you require additional help, or would like to file a development request, take a look at the <a href="#contact">Contact</a> section.

<hr>

<h1 id="freebies">Freebies</h1>

Did you know that as a student you receive a ton of useful benefits and free stuff from different vendors? Here you can find a couple of useful free things you get access to.

<h2 id="azure">Microsoft Azure (and Windows licenses!)</h2>

<details>
  <summary>
  	<b style="color: purple;">Get your free Azure benefits!</b>
  </summary>
  <p>
     Microsoft offers a bunch of free software licenses, as well as hosting time on it's Azure servers. Just head over <a href="https://signup.azure.com/studentverification?offerType=1">here</a> and verify your student status. After doing so, you will find everything you have access to in your Azure's <a href="https://portal.azure.com">homepage</a>.
  </p>
</details>

<h1 id="technical">Technical Stuff</h1>

<h2 id="wifi">WLAN Uni-Bremen</h2>

The document below explains how to set up the Eduroam wifi network on different devices without using 3rd party tools (as I hate such tools).

<details>
  <summary>
  	<b style="color: purple;">Eduroam Wi-Fi Setup</b>
  </summary>
  <div>
   {% capture p5 %} {% include_relative WLAN/README.md %} {% endcapture %} {{ p5 | markdownify }}
  </div>
</details>

<h2 id="printers">Printing in FB3 Uni-Bremen</h2>

<details>
  <summary>
  	<b style="color: purple;">Printing in MZH/FB3 at Uni Bremen</b>
  </summary>
  <div>
   <p>To print anything at the FB3 (in the MZH) the computer science department has moved the printers outside the E0 rooms into the floor and installed a raspberry pi running the <a href="https://www.papercut.com/tour/raspberry-pi/">PaperCut printer server software</a>.</p>

<p>To print a document, simply navigate to https://printerhost.informatik.uni-bremen.de/ then sign in with your university email address and password. Upload the document you wish to print then submit the job. Next, take your nfc tag and head towards the printer. There, just hold your nfc tag against the reader and hit print.</p>
	  
<p><b>Note: you get 300 free pages of print per semester. Use them.</b></p>
  </div>
</details>

<h1 id="wtf-is-git">Just wtf is Git?</h1>

Every developer should know what Git is and how to use it. The below document contains an oversimplified explanation of Git and its functions.

<details>
  <summary>
  	<b style="color: purple;">WTF is Git?</b>
  </summary>
  <div>
   {% capture p6 %} {% include_relative PraktischeInformatik/git/README.md %} {% endcapture %} {{ p6 | markdownify }}
   <a href="#wtf-is-git">Back to Top</a>
  </div>
</details>

<h1 id="mi1">Medieninformatik</h1>

## Grundlagen der Medieninformatik 1

<details>
  <summary>
  	<b style="color: purple;">Tutorium T08 (WiSe21/22)</b>
  </summary>  
{% capture p4 %} {% include_relative Medieninformatik/Medieninformatik1/WiSe2122/slides.md %} {% endcapture %} {{ p4 | markdownify }}
</details>

<details>
  <summary>
  	<b style="color: purple;">Tutorium T12 (WiSe20/21)</b>
  </summary>  
{% capture p1 %} {% include_relative Medieninformatik/Medieninformatik1/WiSe2021/slides.md %} {% endcapture %} {{ p1 | markdownify }}
</details>

<details>
  <summary>
  	<b style="color: purple;">Tutorium T15 (WiSe19/20)</b>
  </summary> 
{% capture p2 %} {% include_relative Medieninformatik/Medieninformatik1/WiSe1920/slides.md %} {% endcapture %} {{ p2 | markdownify }}
</details>

## Grundlagen der Medieninformatik 2

<details>
  <summary>
  	<b style="color: purple;">Tutorium T04 (SoSe21)</b>
  </summary> 
{% capture p3 %} {% include_relative Medieninformatik/Medieninformatik2/SoSe2021/slides.md %} {% endcapture %} {{ p3 | markdownify }}
</details>

<h4>
	<a href="#top">Back to Top</a>
</h4>

<hr>

<h1 id="pi">Praktische Informatik + Exams</h1>

Are you looking for old exams, or for some examples? Take a look at what I got! 


## Praktische Informatik 1: Imperative Programmierung und Objektorientierung

- Git - Introduction, Setup and Usage <a target="_blank" href="https://www.youtube.com/watch?v=Sn01deXJ7M4">(YouTube)
<br/>	<img src="https://i.ytimg.com/vi/Sn01deXJ7M4/hqdefault.jpg?sqp=-oaymwEYCMQBEG5IVfKriqkDCwgBFQAAiEIYAXAB&rs=AOn4CLArEVQdvLBXRkofro_XIX232dnezA"></a>
- Setup SSH in Git <a target="_blank" href="https://www.youtube.com/watch?v=Px15O0sKXS0">(YouTube) <br/> <img src="https://i.ytimg.com/vi/Px15O0sKXS0/hqdefault.jpg?sqp=-oaymwEYCMQBEG5IVfKriqkDCwgBFQAAiEIYAXAB&rs=AOn4CLDsxw1t6dvNUnEoRgCc0kilbqWbMw"></a>

### Beispiele

- LaTeX Introduction <a href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%201%20-%20Imperative%20Programmierung%20und%20Objektorientierung/LaTeX%20Introduction">(Github)</a>

## Praktische Informatik 2: Algorithmen und Datenstrukturen

<img src="https://miro.medium.com/max/3118/1*iwPLQjyFYRTVeQ2cb4S9rA.png" width="850" height="250">

#### Iterator, Comparable & more...

- Iterator Implementation <a href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Iterator%20Implementation">(Gitlab)</a> <a href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Iterator%20Implementation">(Github)</a>

#### Nodes, Linked Lists, Trees & more...

- Simple Linked List <a target="_blank" href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Nodes,%20LinkedLists,%20Trees/LinkedList">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Nodes%2C%20LinkedLists%2C%20Trees/LinkedList">(Github)</a>
- Double Linked List <a target="_blank" href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Nodes,%20LinkedLists,%20Trees/Double%20LinkedList">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Nodes%2C%20LinkedLists%2C%20Trees/Double%20LinkedList">(Github)</a>
- Simple Tree <a target="_blank" href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Nodes,%20LinkedLists,%20Trees/SimpleTree">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Nodes%2C%20LinkedLists%2C%20Trees/SimpleTree">(Github)</a>

#### Search Algorithms

- Linear Search <a target="_blank" href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Search%20Algorithms/LinearSearch">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Search%20Algorithms/LinearSearch">(Github)</a>
- Binary Search <a target="_blank" href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Search%20Algorithms/BinarySearch">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Search%20Algorithms/BinarySearch">(Github)</a>

#### Sorting Algorithms

- Bubble Sort <a href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/BubbleSort" target="_blank">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/BubbleSort">(Github)</a>
- Insertion Sort <a href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/InsertionSort" target="_blank">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/InsertionSort">(Github)</a>
- Merge Sort <a href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/MergeSort" target="_blank">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/MergeSort">(Github)</a>
- Quicksort <a href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/3.%20Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/QuickSort" target="_blank">(Gitlab)</a> <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Beispiele/Praktische%20Informatik%202%20-%20Datenstrukturen%20und%20Algorithmen/Sorting%20Algorithms/QuickSort">(Github)</a>

<h4>
	<a href="#top">Back to Top</a>
</h4>

<hr>

<h1 id="free">Things for your free-time</h1>

While the section on this website contains mostly nonsense, my <a href="https://leolion.tk">other website</a> offers highly sophisticated tools for a wide range of use cases, from bank balance forecasts and investment yield calculations to password creation and cold-storage to digital file transfers and commandline automation.

<h3>
	<img src="https://docs.microsoft.com/en-us/powershell/media/index/powershell_128.svg" width="38" height="24">PowerShell
</h3>

- Bubble Sort <a href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Powershell/Algorithms/BubbleSort">(Github)</a>

### Batchfile

- BATCH Introduction <a target="_blank" href="https://gitlab.informatik.uni-bremen.de/s_xsipo6/university_stuff/tree/master/Etc%20in%20der%20Freizeit/Spass%20mit%20SHELL">(Gitlab)</a> <a href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Spass%20mit%20SHELL">(Github)</a>
- Password-Protected Self-Defending USB <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Spass%20mit%20SHELL/2.%20Password-Protected%20Self-Defending%20USB">(Github)</a>
- 3-Line PC crasher <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Spass%20mit%20SHELL/3.%20PC%20CRASHER">(Github) </a>

<!-- Python Section -->
<h3>
	<img src="https://www.python.org/static/img/python-logo.png" width="168" height="50">
</h3>

- Chatroom using TCP Sockets <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Python/Chatroom">(Github)</a>
- Network Tool <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Python/Network%20Tool">(Github)</a>
- Open-Port Checker <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Python/PortChecker">(Github)</a>
- RGB-YCbCr-DCT Converter (MI-1) <a target="_blank" href="https://github.com/leolion3/University_Stuff/tree/master/Etc%20in%20der%20Freizeit/Python/RGB-DCT-Q">(Github)</a>

<img src="https://github.com/leolion3/University_Stuff/blob/master/Data/Shell.PNG?raw=true">

<h4>
	<a href="#top">Back to Top</a>
</h4>

<hr>

<h1 id="publications">Publications</h1>

<h2 id="bachelor-robots">B-More-Human: Dynamic Cheering Reactions for humanoid Football-Robots (Bachelor Thesis)</h2>

<img src="Publications/data/b-human.jpg"/>

The B-Human football robots were incapable of showing emotions during RoboCup games. This has been changed. The process of doing so required various tweaks dozens of code-fragments throughout the B-Human framework and the introduction of various new mechanisms. 

**The thesis can be found <a href="Publications/BA_B-More-Human_leonard_haddad_SoSe22.pdf">here</a>.**

**Grade: 1.3** (for non-germans, its basically an A, just one step under a 1.0 which is the highest possible grade in Germany.)

**\* The corrections can be provided upon request. Long live open source and free access to information!**

<h4>
	<a href="#top">Back to Top</a>
</h4>

<hr>

<h1 id="me">More from Me...</h1>

Here you can find stuff that I do in my free-time...

<h2>
	<img src="https://www.gstatic.com/android/market_images/web/play_prism_hlock_2x.png" width="168" height="35">
</h2>
<ul>
  <li>
		<h2>
			<img src="https://lh3.googleusercontent.com/iwBywQJPRV8Rk-uuHzMzSspSaTO8AHjgBgeqovw8SlWpdej_vcU68LPLaRa9jptfHlk=s180-rw" width="24" height="24"> Sharky the hungry Sharkfish Game <a target="_blank" href="https://play.google.com/store/apps/details?id=com.SpaceAhoy.Sharky">(Google Play)</a>
		</h2>
	  <img src="https://lh3.googleusercontent.com/O04pRpbIiKpY2r_QRSajjbVJ0cxDMSwJhoHZuXFl6fTBdlJUFj6oSbgS1nTyJghnz7E=w720-h310-rw">
		<p>
			Sharky is very Hungry! Help by feeding him as many fish as you can, but watch out for those nasty harpoons!<br />
	  	Sharky is a family-friendly game designed for all ages. Furthermore it is completely FREE<br /> and AD-FREE. Collect coins to unlock powerups and new skins, and get that highscore!<br />
	  	Sharky is a great time killer for your free time as well!<br /> Be it while waiting at the airport, or in the subway, sharky can played anywhere at any given time!<br /> What are you still waiting for? Get Sharky today!
		</p>
	</li>

  <li>
		<h2>
			<img src="https://lh3.googleusercontent.com/asPozAuGQpJqNz-PB0yesBw9wRGkLDuquGqCf0p47rqBSvhxU5pdNHS27O5fuSF_RyY=s180-rw" width="24" height="24"> SemesterPlaner - Plan your Schedule! <a target="_blank" href="https://play.google.com/store/apps/details?id=com.spaceahoy.semesterplaner">(Google Play)</a>
		</h2>
		<img src="https://lh3.googleusercontent.com/7VQlwaGV-Btk3i9eHY-unfSE1El_0YdQxBfO8yCXA_h4qVnpycARmJgWVFGvnavCuw=w720-h310-rw">
		<img src="https://lh3.googleusercontent.com/7vt1bGzJIL-Pk_uBpK5hXMpATIz9thDZc0m6LmaNn4gdaKkqvnxuE-q4IvZXAUXxiDbc=w720-h310-rw">
		<img src="https://lh3.googleusercontent.com/Dri_kxSxbTtZj5vPwaAgBcjHYk9ICKFnsz52YkFK-V0Y9HEDO4dQ-yBHipLJpQLOksw=w720-h310-rw">
		<img src="https://lh3.googleusercontent.com/jBKn8CFZGN5S1iTFMFcjZJ4ZcbAf668fpEZxE8FHthfntdCOAIEJmE-umYJbYAK-e80=w720-h310-rw">
		<p>Tired of using the same old photoshop template for your semester schedule?<br />
		Why not automate your schedule creation today using Semester Planer!<br />
		Just select your work days, how long you work per day and hit that button!<br />
		Semester Planer will automatically create you a schedule table that can be filled,<br />edited and exported to PNG at any
		given time!<br /> Stop wasting your time and use Semester Planer today!</p>
	</li>

  <li>
		<h2>
			<img src="https://lh3.googleusercontent.com/w_qN0qkMH9B-XmVHDn4GDEFfaISZ3ItJuwahMIqq0BfqW-3_GtLsETiG6URyOy_vKA=s180-rw" width="24" height="24"> Open-Source Password Generator App <a target="_blank" href="https://play.google.com/store/apps/details?id=processing.test.password_generator">(Google Play)</a>
		</h2>
	  <img src="https://lh3.googleusercontent.com/XVku5gPbTFGz4LMZX9N8PnA-ptAwuMck9XifV_vJ3XIFe9pAS-debgjAPU0nlq5ZbZU=w720-h310-rw">
	  <img src="https://lh3.googleusercontent.com/F2CGan-SO4JPkvI7RxjksN97mC5EerzL-rKvzuMvwIOji1COJS_-2Bk59p4tXLd8bsQ=w720-h310-rw">
	  <img src="https://lh3.googleusercontent.com/Ebmg4CAn755JETg3MU2DIOVTVZLZUvJdVINBK2n6PykKf4f_i0coL_gEQObh_VCIA0Y=w720-h310-rw">
		<img src="https://lh3.googleusercontent.com/AZq9XFuuxM06D02eTipgmsPg7UO7iIZL2OiMvayBcOLDG8j3VbrKWBr7gdd1rCt-Aw=w720-h310-rw">
	  <p>
			Passwords can be a real hustle, especially when you have a thousand accounts for a gazillion different websites...<br />
	  	There are some great password generators out there, however how can you ever really trust such a service if it is not open sourced?<br />Stop worrying about your passwords today, with this Free, Open-Source Password Generator!<br />
			Password Generator is completely FREE and AD-FREE, it works 100% offline an creates you a password in seconds!<br />
			The source code can be found on <a href="https://github.com/leolion3/App-Tutorial/tree/master/Password_Generator" target="_blank">Github</a>
		</p>
	</li>
</ul>

<h2>Youtube and stuff...</h2>

<img src="https://logos-world.net/wp-content/uploads/2020/04/YouTube-Logo.png" width="138" height="85">
<ul>
  <li>
		<h2>
			<img src="https://yt3.ggpht.com/a/AGF-l78lu8bZDQn7_80Q2Hx8cXQepB5RWrGd2-cCQQ=s288-c-k-c0xffffffff-no-rj-mo" width="24" height="24"> YouTube Gaming Channel <a target="_blank" href="https://www.youtube.com/channel/UCesXd6uUzs3LGpHQXNAQ3sQ">(YouTube)</a>
		</h2>
	</li>
  <li>
		<h2>
			<img src="https://yt3.ggpht.com/a/AGF-l7_KHJdyFbiDJZkdoPPeKJ30GvW9HhPLKgZp5w=s288-c-k-c0xffffffff-no-rj-mo" width="24" height="24"> YouTube Channel (Tutorials & co) <a target="_blank" href="https://www.youtube.com/channel/UCxBBrZxnsifQsfCK_Rdbj3Q">(YouTube)</a>
		</h2>
	</li>
</ul>
<h4>
	<a href="#top">Back to Top</a>
</h4>
<hr>
<h1 id="contact">Contact</h1>
<p>
	Should you require additional help or have any questions, do contact me under <a href="mailto:s_xsipo6@uni-bremen.de">s_xsipo6@uni-bremen.de</a> - You may write your message in either English, German, Arabic or Hebrew.
</p>
<p>
	For business inquiries, App development requests and other stuff, please contact me personally on one of my social media accounts:
	<ul>
		<li>
			Facebook (General Purpose): <a target="_blank" href="https://www.facebook.com/leonard.haddad">Leonard Haddad</a>
		</li>
		<li>
			Instagram (Development and Photography): <a target="_blank" href="https://www.instagram.com/xleolion3">@xleolion3</a>
		</li>
		<li>
			YouTube (Development): <a target="_blank" href="https://www.youtube.com/channel/UCesXd6uUzs3LGpHQXNAQ3sQ">StrongLions</a> / <a target="_blank" href="https://www.youtube.com/channel/UCxBBrZxnsifQsfCK_Rdbj3Q">The Hi-Tech Lounge</a>
		</li>
</ul>
* If sending a developement request, please do stick with English. Thank You!</p>
<h4>Why Me?</h4>
<p>
	If you are not convinced by the content on this page, then take a look at my <a href="https://github.com/leolion3/University_Stuff/blob/master/Data/CV-ENG.png?raw=true" target="_blank">CV</a>
</p>
<h4>
	<a href="#top">Back to Top</a>
</h4>
<hr>
<h5>DISCLAIMER</h5>
<p>
	The Google Play name and Logo are Copyrighted Google LLC. I do not claim, nor have any affiliation with Google.<br/>
	Powershell and the Powershell Logo are copyrighted Microsoft Corporation. I do not claim, nor have any affiliation with them.<br/>
	Python, the name and the Logo are copyrighted trademarks of the Python Software Foundation. I do not claim, nor have any affiliation with them.
</p>



