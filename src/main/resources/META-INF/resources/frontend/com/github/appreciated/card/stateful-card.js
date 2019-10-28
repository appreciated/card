import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class StatefulCard extends PolymerElement {

    static get template() {
        return html`
        <style>
            #card-content {
                transition: box-shadow 0.35s ease, background-color 0.35s ease;
                box-shadow: 0 0 0 0 rgba(0, 0, 0, 0), 0 0 0 0 rgba(0, 0, 0, 0);
                border-radius: var(--lumo-border-radius, 4px);
                overflow: hidden;
                position: relative;
                user-select: none;
                -webkit-tap-highlight-color: transparent;
                background-color: rgba(255, 255, 255, 0.06);
                width: 100%;
                height: 100%;
            }

            #card-content.touch {
                transition: box-shadow 0.1s ease;
            }

            #card-content[elevation="1"] {
                box-shadow: var(--lumo-box-shadow-s, var(--material-shadow-elevation-2dp));
            }

            #card-content[elevation="2"] {
                box-shadow: var(--lumo-box-shadow-m, var(--material-shadow-elevation-4dp));
            }

            #card-content[elevation="3"] {
                box-shadow: var(--lumo-box-shadow-l, var(--material-shadow-elevation-4dp));
            }

            #card-content:not(.no-elevate):hover {
                box-shadow: var(--lumo-box-shadow-s, var(--material-shadow-elevation-8dp));
            }

            #card-content.selected {
                background-color: var(--card-state-highlight, var(--lumo-contrast-5pct, var(--material-divider-color)));
            }

            #card-content:hover {
                background-color: var(--card-state-highlight, var(--lumo-contrast-5pct, var(--material-divider-color)));
            }

            #card-content[elevation="1"]:not(.no-elevate):hover, #card-content[elevation="1"]:not(.no-elevate).selected {
                box-shadow: var(--lumo-box-shadow-m, var(--material-shadow-elevation-4dp));
            }

            #card-content[elevation="2"]:not(.no-elevate):hover, #card-content[elevation="2"]:not(.no-elevate).selected {
                box-shadow: var(--lumo-box-shadow-l, var(--material-shadow-elevation-8dp));
            }

            #card-content[elevation="3"]:not(.no-elevate):hover, #card-content[elevation="3"]:not(.no-elevate).selected {
                box-shadow: var(--lumo-box-shadow-xl, var(--material-shadow-elevation-16dp));
            }
        </style>
        <div id="card-content">
            <slot></slot>
        </div>`;
    }

    static get is() {
        return 'stateful-card'
    }

    static get properties() {
        return {elevationEnabled: Boolean}
    }

    ready() {
        super.ready();
        if (this.elevationEnabled === true) {
            this.shadowRoot.querySelector("#card-content").classList.remove('no-elevate');
        } else {
            this.shadowRoot.querySelector("#card-content").classList.add('no-elevate');
        }
    }

    enableElevate(enable) {
        this.elevationEnabled = enable;
    }

    preventElementEventPropagation(element) {
        element.addEventListener('down', function (ev) {
            ev.stopPropagation();
        })
        element.addEventListener('click', function (ev) {
            ev.stopPropagation();
        })
    }
}

customElements.define(StatefulCard.is, StatefulCard);