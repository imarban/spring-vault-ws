package com.nearsoft.vaultws;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.vault.annotation.VaultPropertySource;

@Configuration
@VaultPropertySource("")
@Import()
public class VaultConfig {
}
