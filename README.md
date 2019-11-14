# Cognive-microservices

<p>
run <code>gradle wrapper</code> once
</p>
    then <code>gradle [task]</code>. Useful tasks:
        <ul>
            <li><code>clean</code> - to clean</li>
            <li><code>build</code> - to rebuild project</li>
            <li><code>bootRun</code> - to build and run SpringBoot project. 
            Notice that build stops at ~ 70-80%, but project is running</li>
        </ul>


<div>Endpoints:
    <ul>
        <p>GET:</p>
            <ul>
                <li><code>localhost:8080/</code> - echo</li>
                <li><code>localhost:8080/userlists</code> - get all existing lists</li>
                <li><code>localhost:8080/userlists/{number}</code> - get specific list info</li>
            </ul>
        <p>POST:</p>
            <ul>
                <li><code>localhost:8080/create</code> - create list with default name</li>
            </ul>
    </ul>
    
</div>
<p>
TODO:
</p>
    <ul>
        <li>Userlists service:
            <ol>
                <li>Pass "name" parameter to POST "/userlists/create"</li>
                <li>inject UserlistService into ListController based on app args</li>
                <li>implement methods in UserlistServiceDatabase
                    <ul>
                        <li>store in local db</li>
                        <li>store in remote db</li>
                    </ul>
                </li>
            </ol>
        </li> 
    </ul>