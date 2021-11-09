package br.rchlo.cmsblock;

import br.rchlo.cmsblock.presenters.CmsBlockPresenter;
import br.rchlo.cmsblock.service.CmsBlockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CmsBlockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CmsBlockService service;

    private CmsBlockPresenter response;

    @BeforeEach
    public void init() {
        response = buildResponse();
    }

    @Test
    void shouldServiceFind_success() throws Exception {
        Map<String, String> request = new HashMap<>();
         request.put("key1", "value1");
        when(service.find(request)).thenReturn(response);
        this.mockMvc.perform(put("/rest/default/V1/cmsBlock/search")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer ch1g600q1sa3fp3s9e0clts0k6hxbql9"))
                .andExpect(status().isOk());

    }
    @SneakyThrows
    public CmsBlockPresenter buildResponse(){

         String payloadResponse = "{\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"id\": 999,\n" +
                "            \"identifier\": \"info-identifier\",\n" +
                "            \"title\": \"Info \",\n" +
                "            \"content\": \"<div data-content-type=\\\"row\\\" data-appearance=\\\"contained\\\" data-element=\\\"main\\\"><div data-enable-parallax=\\\"0\\\" data-parallax-speed=\\\"0.5\\\" data-background-images=\\\"{}\\\" data-element=\\\"inner\\\" style=\\\"justify-content: flex-start; display: flex; flex-direction: column; background-position: left top; background-size: cover; background-repeat: no-repeat; background-attachment: scroll; border-style: none; border-width: 1px; border-radius: 0px; margin: 0px 0px 10px; padding: 10px;\\\"><div data-content-type=\\\"html\\\" data-appearance=\\\"default\\\" data-element=\\\"main\\\" style=\\\"border-style: none; border-width: 1px; border-radius: 0px; margin: 0px; padding: 0px;\\\">&lt;style&gt;\\r\\n    .container__information {\\r\\n        display: flex !important;\\r\\n        align-items: center;\\r\\n        justify-content: center;\\r\\n        background: #e3e3e3;\\r\\n        box-shadow: 0 0 black;\\r\\n        margin: 0 auto;\\r\\n        text-transform: uppercase;\\r\\n        font-family: 'Arboria';\\r\\n    }\\r\\n\\r\\n    .container__information .item {\\r\\n        display: flex;\\r\\n        justify-content: center;\\r\\n        align-items: center;\\r\\n        height: 110px;\\r\\n        margin-left: 35px;\\r\\n    }\\r\\n\\r\\n    .container__information .item .destaque-verde{\\r\\n        color: #209630;\\r\\n        font-weight: bold;\\r\\n    }\\r\\n\\r\\n    .container__information p {\\r\\n        font-size: 11px;\\r\\n        max-width: 304px;\\r\\n    }\\r\\n\\r\\n    .login::before {\\r\\n        background-image: url(https://midia.fotos-riachuelo.com.br/fotos/hotsites/home/new/icons/ico-login-new.svg);\\r\\n        width: 170px;\\r\\n        height: 26px;\\r\\n        left: -15%;\\r\\n        content: '';\\r\\n        position: relative;\\r\\n        background-position: center;\\r\\n        background-size: contain;\\r\\n        background-repeat: no-repeat;\\r\\n        margin-right: -20px;\\r\\n    }\\r\\n\\r\\n    #carousel__information .retire-em-loja,\\r\\n    #carousel__information .whatsapp{\\r\\n        margin-right: 20px;\\r\\n    }\\r\\n    #carousel__information .cartao-rchlo{\\r\\n        margin-right: 30px;\\r\\n    }\\r\\n\\r\\n    .cartao-rchlo::before {\\r\\n        background-image: url(https://midia.fotos-riachuelo.com.br/fotos/hotsites/home/new/icons/ico-10x-new.svg);\\r\\n        width: 77px;\\r\\n        height: 30px;\\r\\n        left: -15%;\\r\\n        content: '';\\r\\n        position: relative;\\r\\n        background-position: center;\\r\\n        background-size: contain;\\r\\n        background-repeat: no-repeat;\\r\\n        margin-right: -20px;\\r\\n    }\\r\\n\\r\\n    .whatsapp::before {\\r\\n        background-image: url(https://midia.fotos-riachuelo.com.br/fotos/hotsites/home/new/icons/004-whatsapp-1.svg);\\r\\n        width: 34px;\\r\\n        height: 30px;\\r\\n        left: -15%;\\r\\n        content: '';\\r\\n        position: relative;\\r\\n        background-position: center;\\r\\n        background-size: contain;\\r\\n        background-repeat: no-repeat;\\r\\n        margin-right: -20px;\\r\\n    }\\r\\n\\r\\n    .troca-gratis::before {\\r\\n        background-image: url(https://midia.fotos-riachuelo.com.br/fotos/hotsites/home/new/icons/ico-troca-new.svg);\\r\\n        width: 41px;\\r\\n        height: 30px;\\r\\n        left: -15%;\\r\\n        content: '';\\r\\n        position: relative;\\r\\n        background-position: center;\\r\\n        background-size: contain;\\r\\n        background-repeat: no-repeat;\\r\\n        margin-right: -20px;\\r\\n    }\\r\\n\\r\\n    .retire-em-loja::before {\\r\\n        background-image: url(https://midia.fotos-riachuelo.com.br/fotos/hotsites/home/new/icons/noun_mobile_payment_2660881.png);\\r\\n        width: 91px;\\r\\n        height: 30px;\\r\\n        left: -15%;\\r\\n        content: '';\\r\\n        position: relative;\\r\\n        background-position: center;\\r\\n        background-size: contain;\\r\\n        background-repeat: no-repeat;\\r\\n        margin-right: -20px;\\r\\n    }\\r\\n\\t\\r\\n\\r\\n    @media (max-width: 400px) {\\r\\n\\r\\n        .login::before,\\r\\n        .cartao-rchlo::before,\\r\\n        .troca-gratis::before,\\r\\n        .retire-em-loja::before {\\r\\n            margin-right: -14px;\\r\\n        }\\r\\n        .whatsapp::before{\\r\\n            left: -30%;\\r\\n        }\\r\\n        .container__information p {\\r\\n            font-size: 1.1rem;\\r\\n            max-width: 70%;\\r\\n        }\\r\\n        .container__information{\\r\\n            padding: 5px;\\r\\n        }\\r\\n\\r\\n    }\\r\\n\\r\\n    @media (min-width: 575px) {\\r\\n        .container__information .item {\\r\\n            margin-left: 25px;\\r\\n        }\\r\\n\\r\\n        .login::before,\\r\\n        .cartao-rchlo::before,\\r\\n        .troca-gratis::before,\\r\\n        .retire-em-loja::before {\\r\\n            width: 40px;\\r\\n            left: -7%;\\r\\n        }\\r\\n\\r\\n        .login::before {\\r\\n            margin-right: -20px;\\r\\n            width: 63px;\\r\\n        }\\r\\n\\r\\n        .cartao-rchlo::before {\\r\\n            margin-right: -10px;\\r\\n        }\\r\\n\\r\\n        .troca-gratis::before {\\r\\n            margin-right: 0px;\\r\\n        }\\r\\n\\r\\n        .retire-em-loja::before {\\r\\n            margin-right: 0px;\\r\\n        }\\r\\n\\r\\n    }\\r\\n\\r\\n    @media(max-width: 678px){\\r\\n    .f-mob-only{display: block;}\\r\\n    .f-desk-only{display: none;}\\r\\n    }\\r\\n    @media(min-width: 679px){\\r\\n        .f-mob-only{display: none;}\\r\\n        .f-desk-only{display: block;}\\r\\n    }\\r\\n\\r\\n\\t.retire-em-loja::before {\\r\\n    \\tleft: -4%;\\r\\n    }\\r\\n\\t.retire-em-loja p a{\\r\\n\\t\\tfont-weight: bold;\\r\\n\\t}\\r\\n    #carousel__information .item p a{\\r\\n        text-decoration: underline;\\r\\n    }\\r\\n    #carousel__information &gt; div.item.whatsapp &gt; p &gt; a{\\r\\n        text-decoration: none;\\r\\n    }\\r\\n&lt;/style&gt;\\r\\n\\r\\n&lt;div id=\\\"carousel__information\\\" class=\\\"container__information owl-carousel owl-theme\\\"&gt;\\r\\n    &lt;div class=\\\"item retire-em-loja\\\"&gt;\\r\\n        &lt;p&gt;\\r\\n        \\t&lt;a href=\\\"https://contaonline.midwayfinanceira.com.br/contaonline/consulta-boleto?utm_source=home&amp;utm_medium=click&amp;utm_campaign=boletosmidway\\\" title=\\\"Ir para Site Externo da Midway Financeira\\\" target=\\\"_blank\\\"&gt;Clique aqui&lt;/a&gt; para emitir a &lt;span class=\\\"destaque-verde\\\"&gt;Fatura&lt;/span&gt; do Cartão \\r\\n        &lt;/p&gt;\\r\\n    &lt;/div&gt;    \\r\\n    \\r\\n    &lt;div class=\\\"item cartao-rchlo\\\"&gt;\\r\\n        &lt;p&gt;Solicite seu &lt;b&gt;10X sem juros&lt;/b&gt; no Cartão RCHLO*.&lt;/p&gt;\\r\\n    &lt;/div&gt;   \\r\\n    \\r\\n    &lt;div class=\\\"item login\\\"&gt;\\r\\n        &lt;p&gt;\\r\\n            &lt;a href=\\\"/sales/order/history/?nav=home\\\" title=\\\"Ir para Página de Login\\\"&gt; &lt;b&gt;Faça seu login&lt;/b&gt;&lt;/a&gt; e acesse sua conta.\\r\\n        &lt;/p&gt;\\r\\n    &lt;/div&gt;\\r\\n    \\r\\n    &lt;div class=\\\"item troca-gratis\\\"&gt;\\r\\n        &lt;p&gt;&lt;b&gt;Trocas e devoluções&lt;/b&gt;, &lt;a href=\\\"{{store=''}}trocas-e-devolucoes\\\" title=\\\"Ver condições de troca\\\"&gt;clique aqui.&lt;/a&gt;&lt;/p&gt; \\r\\n    &lt;/div&gt;\\r\\n\\r\\n \\r\\n    &lt;div class=\\\"item whatsapp\\\"&gt;\\r\\n        &lt;p&gt;&lt;a href=\\\"https://api.whatsapp.com/send?phone=558007723555&amp;text=Oi,%20Hel%C3%B4!\\\" title=\\\"Abrir no Whatsapp\\\" target=\\\"_blank\\\"&gt;Fale com a Helô via &lt;strong&gt;Whatsapp&lt;/strong&gt; pelo &lt;strong&gt;800-772-3555&lt;/strong&gt;.&lt;/a&gt;&lt;/p&gt;\\r\\n    &lt;/div&gt;\\r\\n&lt;/div&gt;\\r\\n\\r\\n\\r\\n&lt;!--\\r\\n&lt;div id=\\\"f-faixa-frete\\\"&gt;\\r\\n    &lt;img src=\\\"https://midia.fotos-riachuelo.com.br/fotos/hotsites/popups/2019/Chegou-o-APP/App_Desk2.jpg\\\" class=\\\"f-desk-only f-img-fluid\\\" alt=\\\"Baixe o APP\\\"/&gt;\\r\\n    &lt;img src=\\\"https://midia.fotos-riachuelo.com.br/fotos/hotsites/popups/2019/Chegou-o-APP/App_Mob2.jpg\\\" class=\\\"f-mob-only f-img-fluid\\\" alt=\\\"Baixe o APP - Versão Mobile\\\"/&gt;\\r\\n    &lt;div id=\\\"f-botoes-app\\\"&gt;\\r\\n        &lt;a href=\\\"https://apps.apple.com/us/app/riachuelo/id1488532824?ls=1\\\" title=\\\"Baixar o Aplicativo da Riachuelo na Apple Store\\\" class=\\\"f-links-apps\\\"&gt;\\r\\n            &lt;img src=\\\"https://midia.fotos-Riachuelo.com.br/fotos/hotsites/popups/2019/Chegou-o-APP/btn_apple.png\\\"  alt=\\\"Baixe o APP na Apple Store\\\"/&gt;\\r\\n        &lt;/a&gt;\\r\\n        &lt;a href=\\\"https://play.google.com/store/apps/details?id=br.com.riachuelo.app\\\" title=\\\"Baixar o Aplicativo da riachuelo na Play Store\\\" class=\\\"f-links-apps\\\"&gt;\\r\\n            &lt;img src=\\\"https://midia.fotos-riachuelo.com.br/fotos/hotsites/popups/2019/Chegou-o-APP/btn_android.png\\\" alt=\\\"Baixe o APP na Play Store\\\"/&gt;\\r\\n        &lt;/a&gt;\\r\\n    &lt;/div&gt;\\r\\n&lt;/div&gt;\\r\\n--&gt;\\r\\n\\r\\n&lt;script&gt;\\r\\n    require([\\\"jquery\\\", \\\"owlcarousel\\\"], function ($) {\\r\\n\\r\\n        var isMobile = navigator.userAgent.match(/Android/i)\\r\\n            || navigator.userAgent.match(/webOS/i)\\r\\n            || navigator.userAgent.match(/iPhone/i)\\r\\n            || navigator.userAgent.match(/iPad/i)\\r\\n            || navigator.userAgent.match(/iPod/i)\\r\\n            || navigator.userAgent.match(/BlackBerry/i)\\r\\n            || navigator.userAgent.match(/Windows Phone/i)\\r\\n\\r\\n        function startCarousel() {\\r\\n            var owl = $(\\\"#carousel__information\\\");\\r\\n            owl.owlCarousel({\\r\\n                \\\"navText\\\": [\\\"\\\", \\\"\\\"],\\r\\n                \\\"nav\\\": false,\\r\\n                \\\"dots\\\": false,\\r\\n                \\\"loop\\\": false,\\r\\n                \\\"items\\\": 2\\r\\n            });\\r\\n        }\\r\\n\\r\\n        function stopCarousel() {\\r\\n            var owl = $(\\\"#carousel__information\\\");\\r\\n            owl.trigger('destroy.owl.carousel');\\r\\n            owl.addClass('no-carousel');\\r\\n        }\\r\\n\\r\\n        if (isMobile) {\\r\\n            startCarousel();\\r\\n        } else {\\r\\n            stopCarousel();\\r\\n        }\\r\\n\\r\\n    });\\r\\n\\r\\n&lt;/script&gt;\\r\\n\\r\\n\\r\\n\\r\\n&lt;script&gt;\\r\\nrequire([\\\"jquery\\\"], function ($) {\\r\\n    if (screen.width &gt; 768) {\\r\\n        $(\\\".f-links-apps\\\").attr('target','_blank');\\r\\n    }\\r\\n});\\r\\n&lt;/script&gt;</div></div></div>\",\n" +
                "            \"creationTime\": null,\n" +
                "            \"updateTime\": null,\n" +
                "            \"active\": null\n" +
                "        }\n" +
                "    ],\n" +
                "    \"searchCriteria\": {\n" +
                "        \"filterGroups\": [\n" +
                "            {\n" +
                "                \"filters\": [\n" +
                "                    {\n" +
                "                        \"field\": \"identifier\",\n" +
                "                        \"value\": \"info-identifier\",\n" +
                "                        \"conditionType\": \"eq\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"totalCount\": 1\n" +
                "}";


        return objectMapper.readValue(payloadResponse, CmsBlockPresenter.class);
    }

}
